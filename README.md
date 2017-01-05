# About
List of movies and series available in theaters today

# Android application

<p align="center">
  <img src="screenshot.png" width="350"/>
</p>

# How it works

<p align="center">
  <img src="how_it_works.png" width="350"/>
</p>

1 - Web Crawler

Cron job deployed in AWS Beanstalk which will parse www.themoviedb.com, and save the results as JSON, then upload it to AWS S3.

2 - UI

Android application which will consume the json file by doing a GET call.
