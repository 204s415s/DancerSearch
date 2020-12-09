# 概要
Spring BootとMySQLを用いた、簡単な検索が出来るWebアプリケーションです。  
ダンスのレッスンに通おうと思い、どのレッスンにするかを選ぶときには、それぞれのスタジオのサイトに行って、ひとつひとつ探さなければなりません。  
また、スタジオの数も少なくはないため、比較は容易ではないものです。  
なので、レッスンの一覧が一度に見れるようなサイトがあったらいいのではないかと考え、このようなものを作成いたしました。  
「この人のレッスンに通いたい」という要望にも、「どんな人かわからないし、時間が合うものが一度に見たい」という要望にも問題なく対応できると考えています。  
ダンサー名・スタジオの場所・レッスンの曜日や開始時間、などの条件に合うようなダンスレッスンの一覧を表示します。

  

## 開発環境
・Java (version: 1.8.0_261)  
・Spring Boot (version: 2.3.5.RELEASE)  
・MySQL (version: 8.0.22)  
・HikariCP (version: 2.3.2)  
・thymeleaf (version: 3.0.11)  
・gradle (version: 6.6.1)  
・Spring Tool Suite 4 (Version: 4.8.0.RELEASE)  
・Windows10 (64bit)  
以上の環境で開発・動作確認を行いました。

  

## 機能
テキスト入力、またはラジオボタンによる選択で、その条件に合うものが検索できます。複数選択による検索は実装していません。
レッスンの時間に関しては、開始時間と終了時間を指定し、その範囲で検索ができるようにしました。  
この機能を実装するため、時間形式ではなく整数形式で表示しています。 

また、検索結果に、二つのリンクがあります。  
左端のダンサー名をクリックすると、簡単な詳細ページが開き、チーム名・参考動画を閲覧できます。  
右端のリンクは、ダンススタジオの公式サイトが開きます。  
気になったレッスンの詳細を確認したり、スタジオの場所を確認することできます。  
![スクリーンショット (105)](https://user-images.githubusercontent.com/74140214/99505832-ad22cd00-29c4-11eb-9ae4-69f5af1e9a13.png)

  

### 注力した点
二つのテーブルを使用して、それぞれのレッスンの詳細・ダンサー自身の詳細、という二つのページを開くことができるようにしました。  
また、どんな踊り方をする人なのかというのは、レッスン選びにおいて大きなポイントになると考えています。  
それでも、どのように調べたらいいかわからないこともあると思ったため、その場で簡単に雰囲気が掴めるように、ダンサー詳細ページに動画を埋め込みました。 



## テストデータ
サンプルデータの構成は以下のようになっています。  
・データベース: sample_db  
・テーブル: search, dancer, studio, week  
・ユーザー: test_user  

また、サンプルデータを作成するsqlは src/main/resources/sample に入れてあります。



### テーブル定義
テーブルの定義は以下のようになっています。  

searchテーブル
|列名|データ・タイプ|詳細|
|---|---|---|
|id|整数|ID|
|dancer_code|文字列|dancerテーブルと連携|
|dancer|文字列|ダンサー名|
|team|文字列|チーム名|
|studio_id|整数|studioテーブルと連携|
|week_id|文字列|weekテーブルと連携|
|start|整数|レッスン開始時間|
|close|整数|レッスン終了時間|
|level|文字列|クラス|
|link|文字列|公式サイトへのリンク|

dancerテーブル
|列名|データ・タイプ|詳細|
|---|---|---|
|dancer_code|文字列|searchテーブルと連携|
|name|文字列|ダンサー名|
|team|文字列|チーム名|
|movie|文字列|動画(Youtube)のリンク|

studioテーブル
|列名|データ・タイプ|詳細|
|---|---|---|
|studio_id|整数|searchテーブルと連携|
|studio|文字列|スタジオ名|


weekテーブル
|列名|データ・タイプ|詳細|
|---|---|---|
|week_id|整数|searchテーブルと連携|
|week|文字列|曜日|




## 実行
MySQLサーバーを起動した状態で、  
```
gradlew bootRun
```
を実行します。  
http://localhost:8080/index

## デプロイ
デプロイを行ったものは[こちら](https://dancersearch.herokuapp.com/)です。


