
var open_p = document.querySelector('.play_List');
var open_btn = document.querySelector('#open_p_btn');
open_btn.addEventListener('click',()=>{
    open_p.classList.toggle('open_playlist');
})

var songList=['./asset/songs/ringtone.mp3','./asset/songs/radhika.mp3','./asset/songs/animal.mp3','./asset/songs/master.mp3'];
        var audioPlayer=document.getElementById('audioMusic');
        var a=0;
        var index=1;
        var inp=document.getElementsByTagName("input");
        let animateDiv = document.querySelector('.mainAnimate');
        function nextSongPlay()
        {
                 audioPlayer.src=songList[a];

                 audioPlayer.play();
                 inp[1].style.backgroundImage=`url(${'./asset/images/play.png'})`;
                 index=2;
                 if(a<songList.length-1)
                 {
                 a++;
                 }
        }

        function prevSongPlay()
        {
            audioPlayer.src=songList[a];
             audioPlayer.play();
             inp[1].style.backgroundImage=`url(${'./asset/images/play.png'})`;
             index=2;
             if(a>0)
             {
                a--;
             }
        }
      
        function playAndPause()
        {
            if(index==1)
            {
                inp[1].style.backgroundImage=`url(${'./asset/images/play.png'})`;
                audioPlayer.play();
                index=2;
                animateDiv.classList.add('musicAnimate')

            }
            else if(index==2)
            {
                inp[1].style.backgroundImage=`url(${'./asset/images/pause.png'})`;
                audioPlayer.pause();
                index=1;
                animateDiv.classList.remove('musicAnimate')
            }

        }




var canvas = document.querySelector('canvas');
canvas.width = innerWidth;
canvas.height = innerHeight;


var c = canvas.getContext('2d');

var gui = new dat.GUI();


var wave = {
    length:0.01,
    amplitude:100,
    frequencey:0.01
}

const waveFolder = gui.addFolder('wave');
waveFolder.add(wave,'length',-0.01,0.01);
waveFolder.add(wave,'amplitude',-300,300);
waveFolder.add(wave,'frequencey',-0.04,0.01);
waveFolder.open();

var strokeColor ={
    h:360,
    s:50,
    l:50
}
let inc = wave.frequencey;
function animate()
{
  
    requestAnimationFrame(animate);
    c.fillStyle='rgba(0,0,0,0.01)'
   c.fillRect(0,0,innerWidth,innerHeight);
   c.beginPath();
   c.moveTo(0,canvas.height/2);
    for(var i = 0;i<= canvas.width;i++)
   {
    c.lineTo(i,canvas.height/2 + Math.sin(i * wave.length + inc) * wave.amplitude * Math.sin(inc));
  
   }
inc +=wave.frequencey;
c.strokeStyle = `hsl(${strokeColor.h * Math.sin(inc)},${strokeColor.s}%,${strokeColor.l}%)`;
c.stroke();

}
animate();

  