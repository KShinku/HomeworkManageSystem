/**
 * Created by 东旭 on 2017/5/2.
 */
window.onload = function () {
    $("#mask").fadeOut();
}
$("#sign-in").click(function(){
    result=$.ajax({
        url:"/login",
        type:"POST",
        data:{
            account:$("#account").val(),
            password:$("#password").val()
        },
        async:false
    });
    if(result.responseText=="successful"){
        $("html").fadeOut();
        setTimeout("window.location.reload();",500);
    }
    else alert(result.responseText);
});