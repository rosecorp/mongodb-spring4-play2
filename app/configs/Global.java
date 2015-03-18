package configs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import play.Application;
import play.GlobalSettings;
import play.Play;

public class Global extends GlobalSettings {

    private AnnotationConfigApplicationContext ctx;

    @Override
    public void onStart(Application app) {
    	String profile = Play.application().configuration().getString("spring.profile");
        ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles(profile);
        ctx.register(AppConfig.class, MongoCloudConfig.class, MongoConfig.class, MongoLocalConfig.class);
        ctx.refresh();        
    }
        
    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
        return ctx.getBean(clazz);
    }

}