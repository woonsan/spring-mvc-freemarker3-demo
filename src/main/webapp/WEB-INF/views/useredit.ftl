<#ftl outputFormat="HTML">
<html>
<head>
<title>Spring MVC Form Example - User Edit Form</title>
</head>

<h1>Editing User: ${spring.eval("user.firstName + ' ' + user.lastName")}</h1>

<p>${spring.message("user.form.message", user.firstName, user.lastName, user.email)}</p>

<table border="2">
  <tbody>
    <tr>
      <th>${spring.message("user.id")!}</th>
      <td>${user.id}</td>
    </tr>
    <tr>
      <th>${spring.message("user.password")!}</th>
      <td>
        <@spring.bind "user.password"; status>
          <input type="password" name="password" value="${status.value!}" />
        </@spring.bind>
      </td>
    </tr>
    <tr>
      <th>${spring.message("user.email")!}</th>
      <td>
        <@spring.bind "user.email"; status>
          <input type="text" name="email" value="${status.value!}" />
        </@spring.bind>
      </td>
    </tr>
    <tr>
      <th>${spring.message("user.firstName")!}</th>
      <td>
        <@spring.bind "user.firstName"; status>
          <input type="text" name="firstName" value="${status.value!}" />
        </@spring.bind>
      </td>
    </tr>
    <tr>
      <th>${spring.message("user.lastName")!}</th>
      <td>
        <@spring.bind "user.lastName"; status>
          <input type="text" name="lastName" value="${status.value!}" />
        </@spring.bind>
      </td>
    </tr>
    <tr>
      <th>${spring.message("user.birthDate")!}</th>
      <td>
        <@spring.bind "user.birthDate"; status>
          ${spring.transform(status.editor, status.actualValue)!}
        </@spring.bind>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="${spring.message('user.form.submit')!'Save'}" />
        <input type="reset" value="${spring.message('user.form.submit')!'Reset'}" />
      </td>
    </tr>
  </tbody>
</table>

</html>
