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

</head>
<body class="skin-blue layout-top-nav">

    <div class="wrapper">

        <c:import url="/header.jsp"/>

        <div class="content-wrapper">

            <div class="container">

                <section class="content">

                    <div class="row">

                        <c:forEach begin="1" end="100" step="1">

                            <div class="col-sm-4">
                                <div class="box box-widget">
                                    <div class='box-header with-border'>
                                        <div class='user-block'>
                                            <img class='img-circle' src='/static/plugins/AdminLTE-2.3.0/dist/img/user1-128x128.jpg' alt='user image'>
                                            <span class='username'><a href="#">Jonathan Burke Jr.</a></span>
                                            <span class='description'>Shared publicly - 7:30 PM Today</span>
                                        </div><!-- /.user-block -->
                                        <div class='box-tools'>
                                            <button class='btn btn-box-tool' data-toggle='tooltip' title='Mark as read'><i class='fa fa-circle-o'></i></button>
                                            <button class='btn btn-box-tool' data-widget='collapse'><i class='fa fa-minus'></i></button>
                                            <button class='btn btn-box-tool' data-widget='remove'><i class='fa fa-times'></i></button>
                                        </div><!-- /.box-tools -->
                                    </div><!-- /.box-header -->
                                    <div class='box-body'>
                                        <img class="img-responsive pad" src="/static/plugins/AdminLTE-2.3.0/dist/img/photo2.png" alt="Photo">
                                        <p>I took this photo this morning. What do you guys think?</p>
                                        <button class='btn btn-default btn-xs'><i class='fa fa-share'></i> Share</button>
                                        <button class='btn btn-default btn-xs'><i class='fa fa-thumbs-o-up'></i> Like</button>
                                        <span class='pull-right text-muted'>127 likes - 3 comments</span>
                                    </div><!-- /.box-body -->
                                    <div class='box-footer box-comments'>
                                        <div class='box-comment'>
                                            <!-- User image -->
                                            <img class='img-circle img-sm' src='/static/plugins/AdminLTE-2.3.0/dist/img/user3-128x128.jpg' alt='user image'>
                                            <div class='comment-text'>
                      <span class="username">
                        Maria Gonzales
                        <span class='text-muted pull-right'>8:03 PM Today</span>
                      </span><!-- /.username -->
                                                It is a long established fact that a reader will be distracted
                                                by the readable content of a page when looking at its layout.
                                            </div><!-- /.comment-text -->
                                        </div><!-- /.box-comment -->
                                        <div class='box-comment'>
                                            <!-- User image -->
                                            <img class='img-circle img-sm' src='/static/plugins/AdminLTE-2.3.0/dist/img/user4-128x128.jpg' alt='user image'>
                                            <div class='comment-text'>
                      <span class="username">
                        Luna Stark
                        <span class='text-muted pull-right'>8:03 PM Today</span>
                      </span><!-- /.username -->
                                                It is a long established fact that a reader will be distracted
                                                by the readable content of a page when looking at its layout.
                                            </div><!-- /.comment-text -->
                                        </div><!-- /.box-comment -->
                                    </div><!-- /.box-footer -->
                                    <div class="box-footer">
                                        <form action="#" method="post">
                                            <img class="img-responsive img-circle img-sm" src="/static/plugins/AdminLTE-2.3.0/dist/img/user4-128x128.jpg" alt="alt text">
                                            <!-- .img-push is used to add margin to elements next to floating images -->
                                            <div class="img-push">
                                                <input type="text" class="form-control input-sm" placeholder="Press enter to post comment">
                                            </div>
                                        </form>
                                    </div><!-- /.box-footer -->
                                </div>
                            </div>


                        </c:forEach>


                    </div>



                </section>

            </div>





        </div>

    </div>



    <script src="/static/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="/static/plugins/fastclick/fastclick.min.js"></script>
    <script src="/static/plugins/AdminLTE-2.3.0/dist/js/app.js"></script>
    <script src="/static/js/base.js"></script>

</body>
</html>