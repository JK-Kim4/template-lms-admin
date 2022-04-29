let main = {
    init : function (){
        let _this = this;

        $("#submitBtn").on("click", function(){
            _this.save();
        });
    },

    save : function (){

        //유효성 검사 필요
        //data : title, content, authorId

        let data = {
            title : $("#title").val(),
            content : $("#content").val(),
            authorId : $("#authorId").val()
        }

        console.log(JSON.stringify(data));

        $.ajax({
            url : "/book/api/save",
            method : "POST",
            contentType : "application/json; charset=UTF-8",
            dataType : "json",
            data : JSON.stringify(data),
            success : function (result){
                console.log("save result : " + result)
                if(result > 0){
                    alert("등록 성공");
                    window.location.href = "/book/list"
                }else{
                    alert("등록 실패")
                }
            },
            error : function (e, x, h){
                alert("error : " +e);
            }
        })
    }

}

main.init();