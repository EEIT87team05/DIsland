<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DIsland</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <!-- Theme CSS -->
    <link href="<%=request.getContextPath()%>/css/grayscale.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/vendor/jquery/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>
    <!-- Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/js/grayscale.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.twzipcode.js"></script>
<title>DIsland</title>
<style>
.TopbtnStyle {
	position: relative;
	display: inline-block;
	background: #FF7744	;
	border: 1px solid #99D3F5;
	border-radius: 4px;
	padding: 4px 12px;
	overflow: hidden;
	color: #1E88C7;
	text-decoration: none;
	text-indent: 0;
	line-height: 20px;
}

.TopbtnStyle span {
	position: absolute;
	font-size: 20px;
	right: 0;
	top: 0;
	opacity: 0;
}

.TopbtnStyle:hover {
	background: #AADFFD;
	border-color: #78C3F3;
	color: #004974;
	text-decoration: none;
}
li{
	line-height:200px;
}

</style>
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="../index.jsp">
                    <i class="fa fa-camera-retro fa-x">
                    </i> <span class="light">D-</span> Island
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a  href="<%=request.getContextPath()%>/_04_product/ProductListingBookServlet" >立即療傷</a>
                    </li>
                    <li>
                        <a  href="<%=request.getContextPath()%>/_07_game/regionPairing.jsp">立即交友</a>
                    </li>
                    <li>
                        <a  href="<%=request.getContextPath()%>/_03_board/MessageBoard_All.jsp" >立即討拍</a>
                    </li>
                    <li>
                        <a  href="<%=request.getContextPath()%>/_01_register/members.jsp" >會員專區</a>
                    </li>
                    <li>
                        <a  href="<%=request.getContextPath()%>/_07_game/random-first.jsp" >邱比特</a>
                    </li>
                    <li>
                        <a  href="<%=request.getContextPath()%>/_08_gameFate/fate.jsp" >緣點</a>
                    </li>
                     <li>
                        <a  href="<%=request.getContextPath()%>/_01_register/logout.jsp"  >登出</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Header -->
    <header class="intro"/>
        <div class="intro-body"/>
        