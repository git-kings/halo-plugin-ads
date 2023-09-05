package cc.ihxx.ads;

import org.pf4j.PluginWrapper;
import org.springframework.stereotype.Component;
import run.halo.app.plugin.BasePlugin;

/**
 * <p>Plugin main class to manage the lifecycle of the plugin.</p>
 * <p>This class must be public and have a public constructor.</p>
 * <p>Only one main class extending {@link BasePlugin} is allowed per plugin.</p>
 *
 * @author guqing
 * @since 1.0.0
 */
@Component
public class AdsPlugin extends BasePlugin {

    public AdsPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        System.out.println("Ads Plugin Start Success??");
    }

    @Override
    public void stop() {
        System.out.println("Ads Plugin Stop Success??");
    }
}
