<html>
<head>
<title>Spring MVC Form Example - User</title>
</head>

<h1>User</h1>

<table border="2">
  <tbody>
    <tr>
      <th>ID:</th>
      <td>${user.id}</td>
    </tr>
    <tr>
      <th>Password:</th>
      <td>
        <@spring.bind "user.password">
          <input type="password" name="password" value="${status.value!}" />
        </@spring.bind>
      </td>
    </tr>
    <tr>
      <th>E-Mail:</th>
      <td>
        <@spring.bind "user.email">
          <input type="text" name="email" value="${status.value!}" />
        </@spring.bind>
      </td>
    </tr>
    <tr>
      <th>First name:</th>
      <td>
        <@spring.bind "user.firstName">
          <input type="text" name="firstName" value="${status.value!}" />
        </@spring.bind>
      </td>
    </tr>
    <tr>
      <th>Last name:</th>
      <td>
        <@spring.bind "user.lastName">
          <input type="text" name="lastName" value="${status.value!}" />
        </@spring.bind>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit" />
        <input type="reset" value="Reset" />
      </td>
    </tr>
  </tbody>
</table>

</html>
