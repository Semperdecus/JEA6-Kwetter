import {Component, OnInit} from '@angular/core';
import {TweetService} from '../_services';

@Component({
  selector: 'app-new-tweet',
  templateUrl: './new-tweet.component.html',
  styleUrls: ['./new-tweet.component.scss']
})
export class NewTweetComponent implements OnInit {

  public tweet;

  constructor(private tweetService: TweetService) {

  }

  ngOnInit() {
  }

  postTweet() {
    if (this.tweet) {
      this.tweetService.post(this.tweet).subscribe(
        (data) => {
          this.tweetService.messages.next(data);
        });
    }
  }
}
