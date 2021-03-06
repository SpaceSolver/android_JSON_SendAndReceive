# android_JSON_SendAndReceive
## 概要
livedoorの天気WebAPIサービスに接続し、JSON形式のデータを取得し画面に表示する。

## 使用ライブラリ
・Volley
  Volley は、Android アプリのネットワーク操作を簡単にする、そして最も重要なこととして高速化する HTTP ライブラリです。  
  Volley には次のような利点があります。  
   ・ネットワーク リクエストの自動スケジューリング。  
   ・複数のネットワーク接続の同時実行。  
   ・標準の HTTP キャッシュ コヒーレンシを備えた、ディスクとメモリの透過的なレスポンス キャッシュ。  
   ・リクエストの優先順位付けのサポート。  
   ・Cancellation request API。単一のリクエストのキャンセル、ブロックの設定、キャンセル リクエストの範囲の設定ができます。  
   ・カスタマイズ（再試行、バックオフなど）が簡単に行えます。  
   ・強力な順序付けにより、ネットワークから非同期に取得されるデータを UI に正しく簡単に入力できます。  

・Glide  
  Android用の画像読み込みライブラリ  
  このようなライブラリを使う利点は以下の通りです。  
  ・基本的に画像URLと表示するImageViewを指定するだけ  
　・メモリキャッシュ、ファイルキャッシュを自動に行ってくれる  
  ・Gifアニメーションが表示できる

## アプリ動作に関して  
  １．アプリ起動後、[天気教えて]ボタンを押下  
  ２．livedoorのWebAPIに大阪府の天気を取得するリクエストを要求  
  　　GETリクエスト、パラメータとしてcity=270000（大阪府）を設定  
  ３．JSON形式にてレスポンスが返るので、各Viewにデータを設定していく。  
  ４．GIFファイルがURLからImageに変換して代入。  

### リスエスト情報  
URL:livedoorの天気WebAPIサーバー  
http://weather.livedoor.com/forecast/webservice/json/v1

大阪市の天気情報を上記URLの後ろにデータを追加する。  
大阪市：?city=270000

[天気情報API情報ページ](http://weather.livedoor.com/weather_hacks/webservice)

## JSON形式について
  特に専用ライブラリを使わずとも、レスポンスデータを”JSONObject”の型とすることで使用することができる。  
  以下の処理でJSONデータを取得できます。  
  *String data1 = json.getString("data1");*

  [参考サイト JSONデータをパースする方法](https://tkm0on.hatenablog.com/entry/2015/05/21/183608)
