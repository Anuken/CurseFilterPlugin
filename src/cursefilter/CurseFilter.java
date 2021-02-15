package cursefilter;

import arc.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;

import static mindustry.Vars.*;

public class CurseFilter extends Plugin{
    //this is the most curses I've ever typed
    public static final String[] swears = {"shit", "fuck", "asshole", "nigger", "nigga", "niga", "faggot", "dick", "cunt", "bitch"};
    
    @Override
    public void init(){
        netServer.admins.addChatFilter((player, text) -> {
            for(String swear : swears){
                text = text.replaceAll("(?iu)" + swear, "****");
            }

            return text;
        });

        Events.on(PlayerConnect.class, event -> {
            for(String swear : swears){
                if(event.player.name.toLowerCase().contains(swear)){
                    event.player.con.kick("That's not a very nice name.");
                    break;
                }
            }
        });
    }

}
