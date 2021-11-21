function LongonCheck(){
    let flag1=CheckNotNull("UserName1");
    let flag2=CheckNotNull("Password1");
    let flag3=true;
    if (flag2&&flag1) {
        let Obj1=document.getElementById("UserName1");
        let Obj2=document.getElementById("Password1");
        if (Obj1.value==="CMS" && Obj2.value==="123456") flag3=true;
        else {
            let ObjForm=document.getElementById("Password1Form");
            let ObjError=document.getElementById("Password1Error");
            ObjForm.className+=" has-error";
            ObjError.innerHTML="用户名或密码输入错误";
            flag3=false;
        }
    }
    return flag1 && flag2 && flag3
}
function CheckNotNull(ID) {
    let Regular=/^\s*$/;
    let Obj=document.getElementById(ID);
    let ObjForm=document.getElementById(ID+"Form");
    let ObjError=document.getElementById(ID+"Error");
    if(Regular.test(Obj.value)){//如果返回true说明正则匹配成功 也就是名字全是空
        ObjForm.className+=" has-error";
        switch (ID) {
            case "UserName1":
                ObjError.innerHTML="用户名不能为空";
                break;
            case "Password1":
                ObjError.innerHTML="密码不能为空";
                break;
        }
        return false; //表单有问题
    }
    else {
        ObjForm.className="form-group col-sm-12";
        ObjError.innerHTML="";
        return true;
    }
}
