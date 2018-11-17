package com.bryonnabaines.stackoverflow_user_list.di.component;

import android.app.Application;

import com.bryonnabaines.stackoverflow_user_list.App;
import com.bryonnabaines.stackoverflow_user_list.di.ActivityModule;
import com.bryonnabaines.stackoverflow_user_list.di.AppModule;
import com.bryonnabaines.stackoverflow_user_list.di.FragmentModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules={AndroidSupportInjectionModule.class,  ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    void inject(App app);
}
