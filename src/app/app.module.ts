import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CustomMaterialModule} from './core/material.module';
import {AppRoutingModule} from './app-routing.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatGridListModule} from '@angular/material/grid-list';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {AuthService} from './_services';
import {AccountService} from './_services';
import {TweetService} from './_services';
import {HttpClientModule} from '@angular/common/http';
import {TweetComponent} from './tweet/tweet.component';
import {NewTweetComponent} from './new-tweet/new-tweet.component';
import {ProfileCardComponent} from './profile-card/profile-card.component';
import {NavigationBarComponent} from './navigation-bar/navigation-bar.component';
import {HomeComponent} from './home/home.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {MatIconModule} from '@angular/material/icon';
import {DatexPipe} from './_utils/datePipe';
import {AuthGuard} from './_guards';
import {FollowingFollowersComponent} from './following-followers/following-followers.component';
import {AccountSettingsComponent} from './account-settings/account-settings.component';
import { ProfileMenuComponent } from './profile-menu/profile-menu.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TweetComponent,
    NewTweetComponent,
    ProfileCardComponent,
    NavigationBarComponent,
    HomeComponent,
    DatexPipe,
    FollowingFollowersComponent,
    AccountSettingsComponent,
    ProfileMenuComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CustomMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatGridListModule,
    NgbModule,
    MatIconModule,
  ],
  providers: [
    AuthService,
    TweetService,
    AccountService,
    AuthGuard,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
