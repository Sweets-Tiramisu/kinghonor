$(function(){
    (function(){
        var $win = $(window)
        var win_wid = $win.width();
        var win_hei = $win.height();
        $('#j_fixedBar').css({right:'auto',left:win_wid/2+500})

        $('.fixedBar a.goTop').hide();
        $(window).scroll(function(){
            var win_st = $win.scrollTop();

            if(win_st>win_hei/2){
                $('.fixedBar a.goTop').show();
            }else{
                $('.fixedBar a.goTop').hide();
            }
        })
    })();
    
    (function(){
        var $win = $(window)
        var win_wid = $win.width();
        var win_hei = $win.height();
        var pop_wid = $('.pop-box .win').width();
        var pop_hei = $('.pop-box .win').height();
        var pop_wid1 = $('.pop-box1 .win').width();
        var pop_hei1= $('.pop-box1 .win').height();
        var pop_top = (win_hei-pop_hei)/2;
        var pop_left = (win_wid-pop_wid)/2;
        var pop_top1 = (win_hei-pop_hei1)/2;
        var pop_left1 = (win_wid-pop_wid1)/2;
        $('.pop-box .win').css({top:pop_top,left:pop_left});
        $('.pop-box1 .win').css({top:pop_top,left:pop_left1});
    })();
    (function(){
        var $win = $(window)
        var win_wid = $win.width();
        var win_hei = $win.height();
        var pop_wid = $('.pop-box .win').width();
        var pop_hei = $('.pop-box .win').height();
        var pop_wid1 = $('.pop-box1 .win').width();
        var pop_hei1 = $('.pop-box1 .win').height();
       
   
        if(pop_hei==0){
            pop_hei = $('.win_hd').height()+$('.win_bd').height()+$('.win_ft').height();
            if($('.win_bd').height()==0){
                if($('.win_bd_t').height()){
                    pop_hei+=$('.win_bd_t').height()
                }
                if($('.win_bd_b').height()){
                    pop_hei+=$('.win_bd_b').height()
                }    
            }
        }
        if(pop_hei1==0){
            pop_hei1 = $('.win_hd').height()+$('.win_bd').height()+$('.win_ft').height();
            if($('.win_bd').height()==0){
                if($('.win_bd_t').height()){
                    pop_hei1+=$('.win_bd_t').height()
                }
                if($('.win_bd_b').height()){
                    pop_hei1+=$('.win_bd_b').height()
                }
            }
        }

        $('.pop-box .win').height(pop_hei);
        $('.pop-box1 .win').height(pop_hei1);

        var pop_top = (win_hei-pop_hei)/2;
        var pop_left = (win_wid-pop_wid)/2;

        var pop_top1 = (win_hei-pop_hei1)/2;
        var pop_left1 = (win_wid-pop_wid1)/2;
        $('.pop-box .win').css({top:pop_top,left:pop_left});
        $('.pop-box1 .win').css({top:pop_top1,left:pop_left1});

        $('.pop-box .win .close').click(function(event) {
            $('.pop-box').fadeOut(120);
        });

        $('.pop-box1 .win .close').click(function(event) {
            $('.pop-box1').fadeOut(120);
        });


    })();
    (function(){
        $('#newTopicBtn').click(function(event) {
            $('.ft-box').fadeIn(120);
        });
        $('.to-login').click(function(event) {
            $('.login-box').fadeIn(120);
        });
    })();
    
})
