package chr4st.spigot_plugin.waypoints;

import org.bukkit.plugin.java.JavaPlugin;
import chr4st.spigot_plugin.waypoints.commands.CommandWDelete;
import chr4st.spigot_plugin.waypoints.commands.CommandWList;
import chr4st.spigot_plugin.waypoints.commands.CommandWSave;

import java.io.File;

public class Main extends JavaPlugin{
    @Override
    public void onEnable() {
        super.onEnable();
        System.out.println("plugin enabled");

        createWaypointsDir();

        this.getCommand("wsave").setExecutor(new CommandWSave());
        this.getCommand("wlist").setExecutor(new CommandWList());
        this.getCommand("wdelete").setExecutor(new CommandWDelete());

    }

    private void createWaypointsDir() {
        File dir=new File("waypoints");
        if(!dir.exists() || !dir.isDirectory()){
            dir.mkdirs();
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        System.out.println("plugin disabled");
    }
}
