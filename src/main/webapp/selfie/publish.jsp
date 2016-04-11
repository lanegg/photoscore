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

                        <div class="col-sm-5 col-sm-offset-2">
                            <div class="box box-widget">
                                <div class='box-header with-border'>
                                    <div class='user-block'>
                                        <img class='img-circle' src='/static/plugins/AdminLTE-2.3.0/dist/img/user1-128x128.jpg' alt='user image'>
                                        <span class='username'><a href="#">lanegg</a></span>
                                        <span class='description'>2016-04-10 19:00:00</span>
                                    </div><!-- /.user-block -->
                                </div><!-- /.box-header -->
                                <div class='box-body'>
                                    <img class="img-responsive pad" src="${IMAGE_SERVER}/${selfie.photoPath}" alt="Photo">
                                    <%--<p>I took this photo this morning. What do you guys think?</p>--%>
                                    <%--<button class='btn btn-default btn-xs'><i class='fa fa-share'></i> Share</button>--%>
                                    <%--<button class='btn btn-default btn-xs'><i class='fa fa-thumbs-o-up'></i> Like</button>--%>
                                    <%--<span class='pull-right text-muted'>127 likes - 3 comments</span>--%>
                                </div><!-- /.box-body -->
                                <div class="box-footer">
                                    <form action="/selfie/publish/${selfie.id}" method="post">
                                        <textarea name="photoDescribe" class="form-control" placeholder="照片描述"></textarea>
                                        <br>
                                        <div class="row no-print">
                                            <div class="col-xs-12">
                                                <button class="btn btn-success pull-right" type="submit"><i class="fa fa-credit-card"></i> 发布照片</button>
                                                <a class="btn btn-primary pull-right" href="/selfie/toUpload" style="margin-right: 5px;"><i class="fa fa-download"></i> 重新选择</a>
                                            </div>
                                        </div>
                                    </form>
                                </div><!-- /.box-footer -->
                            </div>
                        </div>

                        <div class="col-sm-3">

                            <div class="info-box">
                                <span class="info-box-icon bg-green"><i class="fa fa-flag-o"></i></span>
                                <div class="info-box-content">
                                    <span class="info-box-text">今日照片数</span>
                                    <span class="info-box-number">377</span>
                                </div><!-- /.info-box-content -->
                            </div>

                            <div class="info-box">
                                <span class="info-box-icon bg-red"><i class="fa fa-star-o"></i></span>
                                <div class="info-box-content">
                                    <span class="info-box-text">今日最高分</span>
                                    <span class="info-box-number">8.7</span>
                                </div><!-- /.info-box-content -->
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


</body>
</html>