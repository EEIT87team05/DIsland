//@author: chichi -20160908
// 等於window.onload

		/*---------------------------------------------------欄位檢核區塊*/
		/* account驗證 */

		
		$('#account').bind('blur',function() {
							var AccountCheck = document.getElementById("account").value;
							var emailRule = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
							if (!AccountCheck) {// AccountCheck為空
								document.getElementById("errorMsgAccount").innerHTML 
								= "<img src='../img/error.png' /> E-mail不可為空白！"
							}
							// ^\w+：@ 之前必須以一個以上的文字&數字開頭，例如 abc
							// ((-\w+)：@ 之前可以出現 1 個以上的文字、數字或「-」的組合，例如 -abc-
							// (\.\w+))：@ 之前可以出現 1 個以上的文字、數字或「.」的組合，例如 .abc.
							// ((-\w+)|(\.\w+))*：以上兩個規則以 or 的關係出現，並且出現 0 次以上
							// (所以不能 –. 同時出現)
							// @：中間一定要出現一個 @
							// [A-Za-z0-9]+：@ 之後出現 1 個以上的大小寫英文及數字的組合
							// (\.|-)：@ 之後只能出現「.」或是「-」，但這兩個字元不能連續時出現
							// ((\.|-)[A-Za-z0-9]+)*：@ 之後出現 0
							// 個以上的「.」或是「-」配上大小寫英文及數字的組合
							// \.[A-Za-z]+$/：@ 之後出現 1
							// 個以上的「.」配上大小寫英文及數字的組合，結尾需為大小寫英文
							else {// 有偵測到使用者的輸入資料
								if (AccountCheck.search(emailRule) != -1) {
									document.getElementById("errorMsgAccount").innerHTML 
									= "<img src='../img/success.png' /> E-mail填寫成功！"
								} else {
									document.getElementById("errorMsgAccount").innerHTML 
									= "<img src='../img/error.png' /> E-mail格式錯誤！"
								}

							}
		});
							/* pwd驗證 */
							$('#pwd').bind('blur',function() {
												var PwdCheck = document
														.getElementById("pwd").value;
												var pwdRule = "(?=^[A-Za-z0-9]{6,16}$)((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]))^.*$"

												if (!PwdCheck) {// pwd為空
													document
															.getElementById("errorMsgPwd").innerHTML 
															= "<img src='../img/error.png' /> 密碼不可為空白！"
												} else {// 有偵測到使用者的輸入資料
													if (PwdCheck.search(pwdRule) == -1) {// 使用者輸入的資料符合驗證規則
														document.getElementById("errorMsgPwd").innerHTML 
																= "<img src='../img/error.png' /> 密碼設計請至少大小寫英文+數字！"
													} else {
														document.getElementById("errorMsgPwd").innerHTML 
																= "<img src='../img/success.png' /> 密碼填寫成功！"
													}
												}

		});
							/* 密碼再次確認驗證 */
							$('#pwd_check').bind('blur',function() {
												var PwdCheck = document
														.getElementById("pwd").value;
												var PwdDoubleCheck = document
														.getElementById("pwd_check").value;
												if (!PwdDoubleCheck) {
													document.getElementById("errorMsgPwd_check").innerHTML 
															= "<img src='../img/error.png' /> 確認密碼不可為空白！"
												} else {
													if (PwdCheck != PwdDoubleCheck) {
														document.getElementById("errorMsgPwd_check").innerHTML 
																= "<img src='../img/error.png' /> 您兩次輸入的密碼不一樣！請重新輸入.！"
													} else {
														document.getElementById("errorMsgPwd_check").innerHTML 
																= "<img src='../img/success.png' /> 密碼確認成功！"
													}
											}
			});
						$('#name').bind('blur',function(){
								var NameCheck = document.getElementById("name").value;
								var nameRule="^[\u4E00-\u9FA5]{2,5}$";/*限定只能中文*/
							if (!NameCheck) {
								document.getElementById("errorMsgName").innerHTML 
								= "<img src='../img/error.png' /> 姓名不可為空白！"
									
							} else {
								if(NameCheck.search(NameCheck) == -1){
									document.getElementById("errorMsgName").innerHTML 
									= "<img src='../img/error.png' /> 請填寫2-5字中文！"
								}else{
									document.getElementById("errorMsgName").innerHTML 
									= "<img src='../img/success.png' /> 填寫成功！"
								}		
							}
			});					
							$('#job').bind('blur',function() {
								var JobCheck = document.getElementById("job").value;
										if (!JobCheck) {// 一定要"空白"
												document.getElementById("errorMsgJob").innerHTML 
												= "<img src='../img/error.png' /> 職業不可為空白！"
										} else {
												document.getElementById("errorMsgJob").innerHTML 
												= "<img src='../img/success.png' /> 填寫成功！"
										}
			});

							/*---------------------------------------------------欄位檢核區塊*/


	// Datepicker
				$('#birthday').datepicker(
						{
			
							maxDate : "+0",// 最大選取範圍是當前時間多0天(不可以選擇未來日期)
							changeMonth : true,// 允許更改月
							changeYear : true,// 允許更改年
							dateFormat : "yy-mm-dd",// 修改jQuery顯示時間格式
							defaultDate : (new Date(new Date()
									.getFullYear()
									- 40 + "/01/01")
									- new Date() + 10)
									/ (1000 * 60 * 60 * 24)
						});
				$('#twzipcode').twzipcode({
					'countyName' : 'county', // 預設值為 county
					'districtName' : 'district', // 預設值為 district
					'detect' : true
				// 開啟自動偵測用戶所在位置
				});
				function checkFile() {// 顯示大頭貼區塊
					var reader = new FileReader();
					// 創建 File Oblects
					reader.readAsDataURL(document.getElementById("upload").files[0]);
			
					reader.onload = function(e) {
						var fileContent = e.target.result;
						// 存取結果
						var show = document.getElementById("ImgShowBox");
						show.setAttribute("src", fileContent);
					}
				}