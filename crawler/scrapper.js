var AWS = require('aws-sdk'),
    request = require('request');

module.exports = {
  crawling: function(url, src, path, callback){
    var params = {
      q:"SELECT * FROM html WHERE url='"+src+"' and xpath='"+path+"'",
      format:"json",
      diagnostics:true,
      callback:""
    };

    request({url:url, qs:params}, function(err, response, body) {
      var data = [];
      results=JSON.parse(body).query.results.div;
      results.forEach(function(item){
        if(item.class === 'item poster card'){
          var tmp = item.div[0].a;
          var name = tmp.title;
          var image = tmp.img;
          data.push({
            name: name,
            cover: image ? image["data-src"] : ''
          })
        }
      })
      callback(null, data);
    });
  },
  upload: function(bucket, key, data){
    AWS.config.update({
      signatureVersion: 'v4'
    });
    AWS.config.loadFromPath('./config.json');
    var s3 = new AWS.S3();
    var _data = data;
    s3.createBucket({Bucket: bucket}, function(err, data) {
      var params = {Bucket: bucket, Key: key, Body: _data};
      s3.putObject(params, function(err, data){
        if(err)
          console.log('Something went wrong: %j', err);
        else
          console.log('Uploaded successfuly');
      });
    });
  }
}
