<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>${title}</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
    <link rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>
    <link rel="stylesheet" href="/static/plugins/AdminLTE-2.3.0/dist/css/AdminLTE.css"/>
    <link rel="stylesheet" href="/static/plugins/AdminLTE-2.3.0/dist/css/skins/_all-skins.css"/>
    <link rel="stylesheet" href="/static/css/style.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="/static/css/upload.css">

</head>
<body class="skin-blue layout-top-nav">

    <div class="wrapper">

        <c:import url="/header.jsp"/>

        <div class="content-wrapper">



            <div class="container">

                <section class="content">

                    <div class="row">

                        <div class=" col-sm-8 col-sm-push-2">

                            <div class="box box-widget">
                                <div class="box-body">
                                    <!-- title row -->
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <h2 class="page-header">
                                                <i class="fa fa-globe"></i> 上传照片
                                                <%--<small class="pull-right">Date: 2/10/2014</small>--%>
                                            </h2>
                                        </div><!-- /.col -->
                                    </div>

                                    <div class="well well-sm ">
                                        <p>
                                            选择你的真实照片~
                                        </p>
                                        <div class="alert alert-error" id="errorInfo"></div>

                                    </div>

                                    <!-- this row will not appear when printing -->
                                    <div class="row no-print">
                                        <div class="col-xs-12">
                                            <form action="/selfie/upload" id="photoUploadForm" name="photoUploadForm" method="post"  enctype="multipart/form-data" >
                                                <a href="javascript:;" class="a-upload btn btn-success">
                                                    <input type="file" name="selfie" onchange="uploadPhoto(this)"/><i class="fa fa-credit-card"></i>选择照片
                                                </a>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>

                    </div>


                </section>


            </div>

        </div>


    </div>




    </div>








    <script src="/static/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="/static/plugins/fastclick/fastclick.min.js"></script>
    <script src="/static/plugins/AdminLTE-2.3.0/dist/js/app.js"></script>
    <script src="/static/js/base.js"></script>
    <script src="/static/js/upload.js"></script>


    <script type="text/javascript">
        //TODO 尝试添加到upload.js
        <c:if test="${null == errorInfo || '' == errorInfo}">
            $("#errorInfo").hide();
        </c:if>
    </script>



</body>
</html>