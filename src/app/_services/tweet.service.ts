import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Tweet} from '../_models';
import {AuthService} from './auth.service';
import {Router} from '@angular/router';

@Injectable()
export class TweetService {
  private BASE_URL = 'http://localhost:8080/Kwetter/api/tweet/';

  constructor(private http: HttpClient, private router: Router) {
  }

  getAll() {
    return this.http.get<Tweet[]>(this.BASE_URL);
  }

  getFollowingTweet() {
    if (AuthService.isLoggedIn() === false) {
      return null;
    } else {
      return this.http.get<Tweet[]>(this.BASE_URL + 'following/?username=' + AuthService.getUser());
    }
  }

  post(tweet) {
    if (AuthService.isLoggedIn() === false) {
      return null;
    } else {
      return this.http.post<Tweet>(
        this.BASE_URL + '?message=' + tweet + '&username=' + AuthService.getUser(),
        {}).subscribe(
        () => {
          this.router.navigateByUrl('/home');
        });
    }
  }

  search(message) {
    return this.http.get<Tweet[]>('http://localhost:8080/Kwetter/api/tweet/search/?message=' + message);
  }
}
