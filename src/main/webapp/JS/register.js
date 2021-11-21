function FormCheck(){
    // let flag1=CheckNotNull("Name");
    // let flag2=CheckNotNull("Age");
    alert("注册成功");
    // if(flag1 && flag2){
    //     return false;
    // }else return false;
return false;
}
function CheckNotNull(ID) {
    let Regular=/^\s*$/;
    let Obj=document.getElementById(ID);
    let ObjForm=document.getElementById(ID+"Form");
    let ObjError=document.getElementById(ID+"Error");
    if(Regular.test(Obj.value)){//如果返回true说明正则匹配成功 也就是名字全是空
        ObjForm.className+=" has-error";
        switch (ID) {
            case "Name":
                ObjError.innerHTML="用户名不能为空";
                break;
            case "Age":
                ObjError.innerHTML="年龄不能为空";
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
