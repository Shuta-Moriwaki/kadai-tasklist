<!-- 共通フォームの作成 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="content_tsk">タスク</label><br>
<input type="text" name="content" id="content_tsk" value="${task.content}" />
<br><br>

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>