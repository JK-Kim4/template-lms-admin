let main = {
    init : function (){
        var _this = this;

        $("#submitBtn").click(function(){
            _this.save();
        });
    },
    save : function (){
      let data = $("#authorInsertFrm").serialize();
      console.log("insert data : " + data);
    }
}
