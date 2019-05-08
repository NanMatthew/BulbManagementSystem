module.exports = {
    configureWebpack:{
        devServer:{
            // port:端口号配置
            open:true,//浏览器自启动
            //登陆接口
          //   before(app){
          //       let tokenkey='adminnitor'
          //       app.get('/api/login',(req,res)=>{
          //       const {username,password}=req.query
          //       if(username=='manager' && password=='123456' || username=='admin' && password=='123456'){
          //           res.json({
          //               code:0,
          //               message:'登录成功',
          //               token:tokenkey+'-'+username+'-'+(new Date().getTime()+60*60*1000)
          //           })
          //       }else{
          //     res.json({
          //       code:1,
          //       message:'账号或密码错误'
          //     })
          //   }
          // })  
          //   }
            
        }
    }
}