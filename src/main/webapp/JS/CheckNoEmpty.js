function CheckNoEmpty(){
    alert("test");
    // let flag1=CheckNotNull("UserName");
    // let flag2=CheckNotNull("State");
    // let flag3=CheckNotNull("layer");
    // let flag4=CheckNotNull("room");
    // return flag1 && flag2 && flag3 && flag4
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
            case "UserName1":
                ObjError.innerHTML="用户名不能为空";
                break;
            case "State":
                ObjError.innerHTML="单元号不能为空";
                break;
            case "layer":
                ObjError.innerHTML="楼层不能为空";
                break;
            case "room":
                ObjError.innerHTML="房间号不能为空";
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
