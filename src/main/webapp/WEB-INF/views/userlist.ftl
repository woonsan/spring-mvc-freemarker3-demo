<html>
<head>
<title>Spring MVC Form Example - Users</title>
</head>

<h1>Users</h1>

<table border="2">
  <thead>
    <tr>
      <th>Name</th>
      <th>E-Mail</th>
    </tr>
  </thead>
  <tbody>
    <#list users as user>
    <tr>
      <td><a href="users/${user.id}">${user.firstName} ${user.lastName}</a></td>
      <td><a href="mailto:${user.email}">${user.email}</a></td>
    </tr>
    </#list>
  </tbody>
</table>

</html>
