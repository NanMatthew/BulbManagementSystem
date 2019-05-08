var aText=['a','b','c','d','e','f','g','h','i','j','k','l','m','n',
'o','p','q','r','s','t', 'u','v','w','x','y','z',

'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
'O','P','Q','R','S','T', 'U','V','W','X','Y','Z',];
var Text='';
var Count=0;



var canvas=document.getElementById('canvas');

canvas.width=1420; 
canvas.height=750;

var context=canvas.getContext('2d');

	//顶部
	context.beginPath();
	var topStyle=context.createLinearGradient(0,0,0,100);
	topStyle.addColorStop(0.0,'#333399');
	topStyle.addColorStop(0.5,'#000099');
	topStyle.addColorStop(1.0,'#058');
	context.fillStyle=topStyle;
	context.fillRect(0,0,1420,100);

	//字
	context.beginPath();
	context.font='bold 50px Arial';
	context.fillStyle='white';
	context.textAlign = "center";
	context.textBaseline= 'middle';
	context.fillText("XX系统登录界面",710,50)

	//主体
	context.beginPath();
	context.fillStyle='#FFFFF4'
	context.fillRect(0,100,1420,650);
	context.closePath();



	var canvas2=document.getElementById('canvas2');

	canvas2.width=98; 
	canvas2.height=34;

	var context2=canvas2.getContext('2d');

	drawText(context2);


	function drawText(ctx) {

	var canvas=ctx.canvas;    //ctx.height  为  undefined  ***
	var count=0;
	var R=Math.floor(Math.random()*255);    /*  *****   */
	var G=Math.floor(Math.random()*255);
	var B=Math.floor(Math.random()*255);

	//清空画布
	ctx.clearRect(0,0,canvas.width,canvas.height);
	Text='';

	//背景
	ctx.fillStyle = "rgb("+R+","+G+","+B+")";
	ctx.fillRect(0,0,canvas.width,canvas.height);

	//字符
	ctx.textAlign = "center";
	ctx.textBaseline = "middle";
	ctx.font='bold 20px sans-serif';
	for(var i=0;i<4;i++){
		R=Math.floor(Math.random()*255);    /*  *****   */
		G=Math.floor(Math.random()*255);
		B=Math.floor(Math.random()*255);
		count=setCount();
		ctx.fillStyle = "rgb("+R+","+G+","+B+")";
		ctx.fillText(count,(canvas.width/4*i)+13, canvas.height/2);
		Text=Text+count;   /* *** */
	}
}

function setCount() {
	var count= (Math.ceil(Math.random()*10))%3;
	var result=0;
	for(var i=0;i<3;i++){
		if(count==0){
			result= aText[(Math.ceil(Math.random()*26))%26];
		}
		else if(count==1){
			result=0+(Math.ceil(Math.random()*10))%9;
		}
		else{
			result=aText[(Math.ceil(Math.random()*26))%26+25];
		}
	}
	
	return result;
}
