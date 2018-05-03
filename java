# chuanglan
创蓝demo参考
package
 
com.chuanglan.demo;

import
 
java.io.UnsupportedEncodingException;

import
 
com.alibaba.fastjson.JSON;
import
 
com.chuanglan.sms.request.SmsSendRequest;
import
 
com.chuanglan.sms.response.SmsSendResponse;
import
 
com.chuanglan.sms.util.ChuangLanSmsUtil;
/**
 
* 
 
* @author tianyh 
 
* @Description:普通短信发送
 
*/
public
 
class
 
SmsSendDemo {

    
public
 
static
 
final
 
String charset = 
"utf-8"
;
    
// 用户平台API账号(非登录账号,示例:N1234567)
    
public
 
static
 
String account = 
""
;
    
// 用户平台API密码(非登录密码)
    
public
 
static
 
String pswd = 
""
;

    
public
 
static
 
void
 
main(String[] args) 
throws
 
UnsupportedEncodingException {

        
//请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
        
String smsSingleRequestServerUrl = 
"http://xxx/msg/send/json"
;
        
// 短信内容
        
String msg = 
"【253云通讯】你好,你的验证码是123456"
;
        
//手机号码
        
String phone = 
"187********"
;
        
//状态报告
        
String report= 
"true"
;

        
SmsSendRequest smsSingleRequest = 
new
 
SmsSendRequest(account, pswd, msg, phone,report);

        
String requestJson = JSON.toJSONString(smsSingleRequest);

        
System.out.println(
"before request string is: "
 
+ requestJson);

        
String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        
System.out.println(
"response after request result is :"
 
+ response);

        
SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.
class
);

        
System.out.println(
"response  toString is :"
 
+ smsSingleResponse);


    
}


}



ASP

<%@LANGUAGE=
"VBSCRIPT"
 
CODEPAGE=
"65001"
%>
<%
Function Post(url,data)
    
dim Https 
    
set
 
Https=server.createobject(
"MSXML2.XMLHTTP"
)
    
Https.open 
"POST"
,url,
false
    
Https.setRequestHeader 
"Content-Type"
,
"application/json"
    
Https.send data
    
if
 
Https.readystate=
4
 
then
        
dim objstream 
        
set
 
objstream = Server.CreateObject(
"adodb.stream"
)
        
objstream.Type = 
1
        
objstream.Mode =
3
        
objstream.Open
        
objstream.Write Https.responseBody
        
objstream.Position = 
0
        
objstream.Type = 
2
        
objstream.Charset = 
"utf-8"
        
Post = objstream.ReadText
        
objstream.Close
        
set
 
objstream = nothing
        
set
 
https=nothing
    
end 
if
End Function

dim target,post_data
''
//请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
target = 
"http://xxx/msg/send/json"
  
post_data=
"{"
"account"
":"
"zensen"
","
"password"
":"
"a."
","
"phone"
":"
"18721755342"
","
"msg"
":"
"Server.URLEncode(【253云通讯】您好，您的验证码是999999)"
","
"report"
":"
"false"
"}"
