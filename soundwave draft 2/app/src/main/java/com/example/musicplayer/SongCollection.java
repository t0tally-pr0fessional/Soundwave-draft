package com.example.musicplayer;

public class SongCollection {
    public Song[] songs = new Song[4];
    public SongCollection(){
        Song BillieJean = new Song( "s1001",
                "Billie Jean",
                "Michael Jackson",
                "https://cdn.discordapp.com/attachments/869792200282746914/869792382835646464/Michael_Jackson_-_Billie_Jean_Official_Video.mp3",
                4.9,
                R.drawable.billie_jean);

        Song Photograph = new Song("s1002",
                "Photograph",
                "Ed Sheeran",
                "https://cdn.discordapp.com/attachments/869792200282746914/869792444500303943/Ed_Sheeran_-_Photograph_Official_Music_Video.mp3" ,
                4.32,
                R.drawable.photograph);

        Song LoveDramatic= new Song("s1003",
                "Love Dramatic",
                "Masayuki Suzuki",
                "https://cdn.discordapp.com/attachments/869792200282746914/869792283178983447/Love_Dramatic.mp3",
                4.21,
                R.drawable.love_dramatic);

       Song DaddyDaddyDo= new Song("s1004",
                "Daddy Daddy Do",
                "Masayuki Suzuki",
                "https://cdn.discordapp.com/attachments/869792200282746914/869792770171232266/MVDADDY__DADDY__DO__feat._TVOP.mp3",
                3.16,
                R.drawable.daddy_daddy_do);



        songs[0] = BillieJean;
        songs[1] = Photograph;
        songs[2] = LoveDramatic;
        songs[3] = DaddyDaddyDo;

    }

    public Song getCurrentSong(int currentSongId){
        return songs[currentSongId];
    }

    public int SearchSongById(String Id){
        for(int index = 0; index < songs.length; index++){
            Song tempSong = songs[index];
            if(tempSong.getId().equals(Id)){ return index; }
        }
        return -1;
    }
    public int getNextSong(int currentSongIndex) {
        if (currentSongIndex >= songs.length - 1) {
            return currentSongIndex;
        } else {
            return currentSongIndex + 1;
        }
    }
        public int getPrevSong(int currentSongIndex) {
            if (currentSongIndex <= 0) {
                return currentSongIndex;
            }else{
                return currentSongIndex - 1;
            }


        }
    }


