var config=require('./config'),
    scrapper=require('./scrapper'),
    async = require('async');

async.parallel({
  movies: function(callback){
    scrapper.crawling(config.URL, config.MOVIES, config.XPATH, callback);
  },
  series: function(callback){
    scrapper.crawling(config.URL, config.SERIES, config.XPATH, callback);
  }
}, function(err, results){
  scrapper.upload(config.BUCKET, config.KEY, JSON.stringify(results));
});
