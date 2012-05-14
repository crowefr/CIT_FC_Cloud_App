<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>Please Login</title></head><body onload='document.f.j_username.focus();'>
<link rel="stylesheet" href="styles/style.css">
<h3>Login with Username and Password</h3><form name='f' action='/j_spring_security_check' method='POST'>
 <table>
    <tr><td>User:</td><td><input type='text' name='j_username' value=''></td></tr>
    <tr><td>Password:</td><td><input type='password' name='j_password'/></td></tr>
    <tr><td colspan='4'><input name="submit" type="submit" value="Login"/></td></tr>
  </table>
</form></body></html>