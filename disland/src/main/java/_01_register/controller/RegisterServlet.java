/*
 * @author : chichi on 2016/09/16
 * 
 * */
package _01_register.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import _00_init.GlobalService;
import _01_register.model.MemberBean;
import _01_register.model.MembersDAO;
import _01_register.model.MembersVO;


//-----------------------------------------------------
/* Annotation 寫法可以改用 web.xml檔案 表示之
<multipart-config>
<location>/tmp</location>
<max-file-size>20848820</max-file-size>
<max-request-size>418018841</max-request-size>
<file-size-threshold>1048576</file-size-threshold>
</multipart-config>
*/
//MultipartConfig的屬性說明:
//location: 上傳之表單資料與檔案暫時存放在Server端之路徑，此路徑必須存在。
//fileSizeThreshold: 檔案的大小臨界值，超過此臨界值，
//上傳檔案會用存放在硬碟，否則存放在主記憶體。
//maxFileSize: 上傳單一檔案之長度限制，如果超過此數值，Web Container會丟出例外
//maxRequestSize: 上傳所有檔案之總長度限制，如果超過此數值，Web Container會丟出例外
@MultipartConfig(location = "", fileSizeThreshold = 1024, // 1K，預設0
		maxFileSize = 1024 * 1024 * 5, // 5M
		maxRequestSize = 1024 * 1024 * 5 * 5 // 25M
)
// 限制檔案大小為
@WebServlet("/_01_register/register.do")

public class RegisterServlet extends HttpServlet {

	/**
	 * 為了在反序列化時，確保類版本的兼容性， 最好在每個要序列化的類中加入 private static final long
	 * serialVersionUID這個屬性，具體數值自己定義。 在警告上點左鍵就可以自動添加。當然也可以去掉警告。
	 * 設置：Window-->Preferences-->Java， 將serializable class without
	 * serialVersionUID的設置由warning改為Ignore。 然後Eclipse會重新編譯程序，那些警告信息也就消失了。
	 * serialVersionUID用來作為Java對象序列化中的版本標示之用； 如果一個序列化類沒有聲明這樣一個static
	 * final的產量，JVM會根據各種參數為這個類計算一個； 對於同樣一個類， 不同版本的JDK可能會得出不同的serivalVersionUID;
	 * 你可以隨便寫一個，在Eclipse中它替你生成一個，有兩種生成方式： 一個是默認的1L，比如：private static final long
	 * serialVersionUID = 1L; 一個是根據類名、接口名、成員方法及屬性等來生成一個64位的哈希字段， 比如：private
	 * static final long serialVersionUID = -8940196742313994740L;之類的。
	 */
	private static final long serialVersionUID = 1L;
	private static final int Members_ID = 0;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		response.setCharacterEncoding("UTF-8");// 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，
		// 所以需要session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息
		Collection<Part> parts = request.getParts();
		// GlobalService.exploreParts(parts, request);
		String account =  request.getParameter("account");
		String pwd =  request.getParameter("pwd");
		String pwd_check =  request.getParameter("pwd_check");
		String name = request.getParameter("name");
		String birthday =  request.getParameter("birthday");
		String nickname =  request.getParameter("nickname");
		String twzipcode = request.getParameter("twzipcode");
		String height=  request.getParameter("height");
		String weight =  request.getParameter("weight");
		String job =  request.getParameter("job");
		String relationship =  request.getParameter("relationship");
		String gender = request.getParameter("gender");
		String constellation = request.getParameter("constellation");//Members_Constellation
		String sex = request.getParameter("sex");
		String upload =  request.getParameter("upload");
		String fileName =  request.getParameter("fileName");
		String county=request.getParameter("county");//Members_City
		String district=request.getParameter("district");//Members_Area
		String address=request.getParameter("address");//Members_Address
		String introduce=request.getParameter("introduce");//Members_Itroduce
		
		long sizeInBytes = 0;
		InputStream is = null;

		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) { // 將表單的資料逐一取出
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equals("account")) {
						account = value;
					} else if (fldName.equals("pwd")) {
						pwd = value;
					} else if (fldName.equalsIgnoreCase("pwd_check")) {
						pwd_check = value;
					} else if (fldName.equalsIgnoreCase("name")) {
						name = value;
					} else if (fldName.equalsIgnoreCase("birthday")) {
						birthday = value;
					} else if (fldName.equalsIgnoreCase("nickname")) {
						nickname = value;
					} else if (fldName.equalsIgnoreCase("job")) {
						job = value;
					} else if (fldName.equalsIgnoreCase("height")) {
						height = value;
					} else if (fldName.equalsIgnoreCase("weight")) {
						weight = value;
					} else if (fldName.equalsIgnoreCase("gender")) {
						gender = value;
					} else if (fldName.equalsIgnoreCase("relationship")) {
						relationship = value;
					} else if (fldName.equalsIgnoreCase("sex")) {
						sex = value;
					}
				} else {
					fileName = GlobalService.getFileName(p); // 此為圖片檔的檔名
					fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
					if (fileName != null && fileName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					} else {
						errorMsg.put("errPicture", "必須挑選圖片檔");
					}
				}
			} // end if parts (表單)
		
			//2.進行相關資料型態轉換
			try {
				height = (job.trim()).toString();
			} catch (NumberFormatException e) {
				errorMsg.put("errorFormat","格式錯誤，應該為字串");
			}
			
			// 3. 檢查使用者輸入資料
						if (account == null || account.trim().length() == 0) {
							errorMsg.put("errorIDEmpty","帳號欄必須輸入");
						}
						if (pwd == null || pwd.trim().length() == 0) {
							errorMsg.put("errorPasswordEmpty","密碼欄必須輸入");
						}
						if (pwd_check == null || pwd_check.trim().length() == 0) {
							errorMsg.put("errorPassword2Empty","密碼確認欄必須輸入");
						}
						if (pwd.trim().length() > 0 && pwd_check.trim().length() > 0){
							if (!pwd.trim().equals(pwd_check.trim())){
								errorMsg.put("errorPassword2Empty","密碼欄必須與確認欄一致");
								errorMsg.put("errorPasswordEmpty","*");
							}			
						}
						if (name == null || name.trim().length() == 0) {
							errorMsg.put("errorName","姓名欄必須輸入");
						}
						if (birthday == null || birthday.trim().length() == 0) {
							errorMsg.put("errorBirthday","生日欄必須輸入");
						}
						if (nickname == null || nickname.trim().length() == 0) {
							errorMsg.put("errorEmail","暱稱欄必須輸入");
						}
						if (job == null || job.trim().length() == 0) {
							errorMsg.put("errorTel","職位欄必須輸入");
						}
						if (twzipcode == null || twzipcode.trim().length() == 0) {
							errorMsg.put("errorTel","地區欄必須輸入");
						}
						if (height == null || height.trim().length() == 0) {
							errorMsg.put("errorTel","身高欄必須輸入");
						}
						if (weight == null || weight.trim().length() == 0) {
							errorMsg.put("errorTel","體重欄必須輸入");
						}
						if (gender == null || gender.trim().length() == 0) {
							errorMsg.put("errorTel","性別欄必須輸入");
						}
						if (relationship == null || relationship.trim().length() == 0) {
							errorMsg.put("errorTel","感情狀態欄必須輸入");
						}
						if (sex == null || sex.trim().length() == 0) {
							errorMsg.put("errorTel","性取向欄必須輸入");
						}
				}else{
					
				}
					if (!errorMsg.isEmpty()) {
					// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.forward(request, response);
					return;
					}
					try {
						// 4. 進行Business Logic運算
						MembersVO mb = new MembersVO(Members_ID, account, pwd, name, gender, constellation, height, weight, county, district, relationship, job, address, introduce);
						MembersDAO mdao = new MembersDAO();
						mdao.insert(mb, is, sizeInBytes, fileName);
						session.setAttribute("memberBean", mb);
						//資料新增成功後跳轉到成功頁面
					    response.sendRedirect(response.encodeRedirectURL("InsertMemberSuccess.jsp"));
					}catch(SQLException e){
						e.printStackTrace();
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		}
	}
	
	

