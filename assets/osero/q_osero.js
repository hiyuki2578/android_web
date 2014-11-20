p=0;
q=0;
flg=0;
f=0;
jun=0;
tensu=0;iti=0;
ten0=0;
atjun=2;
var dmp;
var dmq;


/////////////////////////////////////////////////////////////
function junset(){
if(atjun==2){atjun=1;}else{atjun=2;}
qpon1();
}
function at(){
if(atjun==jun){
	tensu=0;iti=0;fff=0;

	for(ii=10;ii<91;ii++){
		if(isi[ii]==0){

			ten0=0;
			chackAT(ii);
			ten0=(ten0*ten[ii]);
			if (tensu<ten0){
				tensu=ten0;iti=ii;
			}
		}
	}
	if (tensu>0){
 		qpon0(iti);
	}
	else{
		qpon1();
	}
}
}
////////////////////////////////////////////////////////////
function chackAT(p0){			
	flg=0;
	pp=p0;
	pjun=jun+1;
	if(pjun>2){
		pjun=1;
	}
	
		xy=1;if(isi[pp+xy] == pjun){xyAT2();}	
		xy=-1;if(isi[pp+xy] == pjun){xyAT2();}	
		xy=9;if(isi[pp+xy] == pjun){xyAT2();}	
		xy=10;if(isi[pp+xy] == pjun){xyAT2();}
		xy=11;if(isi[pp+xy] == pjun){xyAT2();}	
		xy=-9;if(isi[pp+xy] == pjun){xyAT2();}	
		xy=-10;if(isi[pp+xy] == pjun){xyAT2();}
		xy=-11;if(isi[pp+xy] == pjun){xyAT2();}
}

/////////////////////////////////////////////////////////////////
function xyAT2(){	
	
		f=0;		
		for(j=pp+xy;isi[j]>0;j=j+xy){
			if(isi[j]==jun  && f==0){
				f=j;
			}
		}	
		ff=f;
		if (f>0){
			for(j=pp+xy;j!=f;j=j+xy){
				if(isi[j]<=0){
					ff=0;
				}
			}	
		}
		f=ff;		
		if (f>0){
			flg=f;
			for(j=pp+xy;j != f;j=j+xy){
				ten0=ten0+1
			}
		}
}
////////////////////////////////////////////
function qpon(p){
flg=0;
 qpon0(p);
if (flg>=1){
//at();
}
}
function qpon0(p){
q="game"+p;
	if(isi[p] == 0){		
		chack(p)
		if (flg >0){
			isi[p]=jun;
			document[q].src= img_url+tip_img[(isi[p]+2)];
				if(dmp>0){document[dmq].src= img_url+tip_img[(isi[dmp])];}
				dmq=q;
				dmp=p;
			jun++;
			if (jun>2){
				jun=1;
			}
if(jun==1){
document.ban1.src=img_url+tip_img[3];
document.ban2.src=img_url+tip_img[2];
}else{
document.ban1.src=img_url+tip_img[1];
document.ban2.src=img_url+tip_img[4];

}
		}
	}
	ten1=0;ten2=0;
	for(j=10;j<=90;j++){
		if(isi[j]==1){	
			ten1++;
		}
		if(isi[j]==2){
			ten2++;
		}
	}
		document.MyForm.box1.value=parseInt(ten1);
		document.MyForm.box2.value=parseInt(ten2);

}

////////////////////////////////////////////////////////////
function chack(p0){			
	flg=0;
	pp=p0;
	qq="game"+1;
	pjun=jun+1;if(pjun>2){pjun=1;}
	s=((pp-1)%8)+1;
	t=parseInt((pp-1)/8)*8;
		xy=1;if(isi[pp+xy] == pjun){xy2();}	
		xy=-1;if(isi[pp+xy] == pjun){xy2();}	
		xy=9;if(isi[pp+xy] == pjun){xy2();}	
		xy=10;if(isi[pp+xy] == pjun){xy2();}	
		xy=11;if(isi[pp+xy] == pjun){xy2();}	
		xy=-9;if(isi[pp+xy] == pjun){xy2();}	
		xy=-10;if(isi[pp+xy] == pjun){xy2();}	
		xy=-11;if(isi[pp+xy] == pjun){xy2();}	
}

/////////////////////////////////////////////////////////////////
function xy2(){	
	
		f=0;		
		for(j=pp+xy;isi[j]>0;j=j+xy){
			if(isi[j]==jun  && f==0){
				f=j;
			}
		}	
		ff=f;
		if (f>0){
			for(j=pp+xy;j!=f;j=j+xy){	
				if(isi[j]<=0){
					ff=0;
				}
			}	
		}
		f=ff;		
		if (f>0){
			flg=f;
			for(j=pp+xy;j != f;j=j+xy){
				isi[j] =jun;
				qqq="game"+(j);
				document[qqq].src=img_url+ tip_img[(isi[j])];
			}
		}
}
///////////////////////////////////////////////////////////

function qpon1(){
			jun++;
			if (jun>2){
				jun=1;
			}

//alert("4");
/////		document.game0.src= img_url+tip_img[(jun)];

}

/////
//document.write('<table><tr><td align=center>');
document.write('<form name="MyForm">');
//document.write('<font size=6 >ＱＰＯＮオセロ</font>');

document.write('<table border=0><tr><th valign="top">先手<br><br> ');
document.write('<img src="',img_url,tip_img[3],'" width=46 height=46 name="ban1"><br>あなた<br><br>');
document.write('得点<br><input type="text" name="box1" size=3><br><br>');
document.write('<input type=button value="パス" onClick="qpon1()" onMouseOut="at()">');
document.write('</th><th>');
//
/*	初期設定	*/
function MakeArray(m){
	this.Length=m;
	}
	nav=navigator.appName.substring(0,1);
	ver=navigator.appVersion.substring(0,1);
	nv=nav+ver;
	var m='"';
	isi=new MakeArray(100);
	ten=new MakeArray(100);

jun=1;
for(i=1;i<=10;i++){
	isi[i]=-1;
}
for(i=11;i<=90;i++){
	isi[i]=0;
}
for(i=91;i<=100;i++){
	isi[i]=-1;
}
isi[4*10+4]=1;
isi[4*10+5]=2;
isi[5*10+4]=2;
isi[5*10+5]=1;

/////////////////////

dm="0000000000514334150011333311004332233400332222330033222233004332233400113333110051433415000000000000"
for(i=1;i<=100;i++){
	ten[i]=parseInt(dm.substring(i-1,i))*(Math.random()+1);

}
/*	パイの表示	*/
document.write("<table border=4 bgcolor='#008800'>");
for(i=10;i<=90;i++){
/*	パイの表示位置	*/
		if(i%10==0){
			document.write("<tr>");	
			isi[i]=-1;
		}
	
		if(i%10==9){
			document.write("</tr>");
			isi[i]=-1;
		}
		if(i%10>0 && i%10<9){
/*
if(document.layers){		
			document.write("<td><a href="+m+"javascript:qpon("+i+")"+m+" onMouseOut=at()>"  );
			
			document.write("<img name='game"+i+"' src='"+img_url+tip_img[(isi[i])]+"' border=0 alt='' width=46 height=46>");
			document.write("</a></td>");
}else{
*/
			document.write("<td>"  );
			
//			document.write("<img name='game"+i+"' src='"+img_url+tip_img[(isi[i])]+"' border=0 alt='' width=46 height=46 onClick='qpon("+i+")' onMouseOut='at()'>");
			document.write("<img name='game"+i+"' src='"+img_url+tip_img[(isi[i])]+"' border=0 alt='' width=46 height=46 onClick='qpon("+i+");setTimeout(\"at()\",3000)'>");

			document.write("</td>");
//}		
		}	
	
}

document.write("</table>");
document.write('</th><th valign="bottom">後手<br><br>');
document.write('<img src="',img_url,tip_img[2],'" width=46 height=46 name="ban2"><br>');
document.write('コンピューター<br><br>得点<br>');
document.write('<input type="text" name="box2" size=3><br><br>');
document.write('<input type=button value="パス" onClick="qpon1()" onMouseOut="at()"><br><br>');
document.write('</th></tr><tr><td></td><td align=right>');

document.write('<a href="http://www2a.biglobe.ne.jp/~qpon/js/index.htm?http://qpon.quu.cc/game/osero/q_osero_b.htm" target="_top"><font size=1>システム提供：ＱＰＯＮ</font></a> ');
document.write('<br><a href="https://www.twitter.com/hiyuki2578" target="_top"><font size=1>modified:hiyuki2578</font></a> ');
document.write('</form>');
document.write('</td><td></td></tr></table>');
//document.write('</center>');
