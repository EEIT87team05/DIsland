<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="//connect.facebook.net/zh_TW/all.js"></script>
<!-- 只要有facebook javascript SDK的地方就要有fb-root。 -->
<div id="fb-root"></div>

<!-- 登入按鈕外掛程式配置器開始 -->
<div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="true" data-auto-logout-link="true"></div>
<!-- 登入按鈕外掛程式配置器結束 -->


<!-- 登入主程式開始 -->
<script>
	window.fbAsyncInit = function() { //初始化Facebook js sdk
		  console.log("3");
		    FB.init({ 
		      appId      : '1769609086631869', // App ID from the app dashboard
		      xfbml      : true,               // Look for social plugins on the page
		      version    : 'v2.7'
		    });
			FB.getLoginStatus(function(response) {
				  console.log("4");
			  statusChangeCallback(response);
			});
		  };

//載入您的網頁時，第一個步驟是確認用戶是否已經使用「Facebook 登入」來登入您的應用程式。呼叫 FB.getLoginStatus 來啟動這個程序。這個函數會觸發對 Facebook 的呼叫來取得登入狀態，接著呼叫您的回呼函數來傳回結果。

	


  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
	  console.log("1");
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      FB.login(function(response) { //跳出視窗
      }, {scope: 'public_profile,email'});//取得公開的個人資料、要授權的email
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else{
        // The person is not logged into Facebook, so we're not sure if
        // they are logged into this app or not.
        document.getElementById('status').innerHTML = 'Please log ' +
          'into Facebook.';
    }
  }
  
  
  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
	  console.log("2");
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }



  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.



//   FB.getLoginStatus(function(response) {
// 	    if (response.status === 'connected') {
// 	        // the user is logged in and has authenticated your app,
// 	        // and response.authResponse supplies
// 	        // the user's ID, a valid access token, a signed request, 
// 	        // and the time the access token and signed request each expire

// 	        //get access token, and save it in local storage
// 	        localStorage.setItem('accessToken', response.authResponse.accessToken);

// 	        //check user, in order to get user info
// 	        checkUser();
// 	    }
// 	    else if (response.status === 'not_authorized') {
// 	        // the user is logged in to Facebook, but has not authenticated the app
// 	    }
// 	    else {
// 	        //response.status === 'unknown'
// 	        // the user isn't logged in to Facebook.
// 	    }
// 	});
//  };

  // Load the SDK asynchronously
  (function(d, s, id) {
	  console.log("5");
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/zh_TW/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name + response.id + response.email);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }
</script>

<!--
  Below we include the Login Button social plugin. This button uses
  the JavaScript SDK to present a graphical Login button that triggers
  the FB.login() function when clicked.
-->

<!-- 去掉原本登入按鈕開始 -->
<!-- <fb:login-button scope="public_profile,email" onlogin="checkLoginState();"> -->
<!-- </fb:login-button> -->
<!-- 去掉原本登入按鈕結束 -->
<div id="status">
</div>
<!-- 登入主程式結束 -->


<!-- 讚跟分享開始 -->
<div
  class="fb-like"
  data-share="true"
  data-width="450"
  data-show-faces="true">
</div>
<!-- 讚跟分享結束 -->



<!-- 要使用javascript SDK，必須先include進函式庫  開始 -->
<!-- <script> -->
<!--   window.fbAsyncInit = function() { //初始化Facebook js sdk -->
<!--     FB.init({  -->
<!--       appId      : '1769609086631869', // App ID from the app dashboard -->
<!--       xfbml      : true,               // Look for social plugins on the page -->
<!--       version    : 'v2.7' -->
<!--     }); -->
<!--   }; -->

<!--   //使用Facebook SDK前一定要先會導入Facebook提供的API，如Javascript的SDK官方公布的導入方式如下： -->
<!--   //這是我們在官方網站常看到的導入方式並抄來改成zh_TW的版本，這段程式碼執行完後Facebook Javascript SDK才會導入， -->
<!--   //而且此方法因為使用非同步處理而不能馬上在下方就開始使用，如果要使用到Facebook的功能必須將程式碼全部都包含在"window.fbAsyncInit"這個Function裡面 -->
<!--   (function(d, s, id){  -->
<!--      var js, fjs = d.getElementsByTagName(s)[0]; -->
<!--      if (d.getElementById(id)) {return;} -->
<!--      js = d.createElement(s); js.id = id; -->
<!--      js.src = "//connect.facebook.net/zh_TW/sdk.js"; -->
<!--      fjs.parentNode.insertBefore(js, fjs); -->
<!--    }(document, 'script', 'facebook-jssdk')); -->
<!-- </script> -->
<!-- 要使用javascript SDK，必須先include進函式庫  結束 -->



</body>
</html>