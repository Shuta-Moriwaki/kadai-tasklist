<!-- 共通ひな形の作成 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>タスク管理表</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>タスク管理アプリケーション</h1>
            </div>
        </div>
        <div id="content">
            ${param.content} <!-- 各ページのビューの内容が入る -->
        </div>
        <div id="footer">
            by Shuta Moriwaki.
        </div>
    </body>
</html>