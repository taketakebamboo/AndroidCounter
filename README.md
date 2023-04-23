# AndroidCounter
アンドロイドスタジオでカウンターアプリを作る

# Github連携
#### コミットまでの手順[参考](https://inomacreate.com/androidstudio-git/)
1. 左上のツールバーから`VCS`を選択し`Enable Version Control Integration...`を選択
2. タブが開き、プルダウンメニューから`Git`を選択しOKをクリック
3. 左沿いのツールバーから`commit`を選択後、commitしたいファイルにチェックしcommitボタンをクリック
4. タブが開くので`commit`をクリック

# GitHubでレポジトリを作成するときにREADME.mdやライセンスを追加してやると，ローカルで作ったレポジトリをそこへpushするときにエラーが出る．
```
$ git push origin master
To https://github.com/TRSasasusu/ほげほげ
! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://github.com/TRSasasusu/ほげほげ'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```
そこで，README.mdやライセンスの差分をローカルに落とすためにpullすると，
```
$ git pull origin master
warning: no common commits
remote: Enumerating objects: 4, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (4/4), done.
remote: Total 4 (delta 0), reused 0 (delta 0), pack-reused 0
Unpacking objects: 100% (4/4), done.
From https://github.com/TRSasasusu/ほげほげ
* branch            master     -> FETCH_HEAD
* [new branch]      master     -> origin/master
  fatal: refusing to merge unrelated histories
 ```
  とこちらもエラーが出てしまう．このエラーを回避してpullするには，

`$ git pull --allow-unrelated-histories origin master`
としてやれば良い．これであとは

`$ git push origin master`
でリモートレポジトリにpushできる．

# 変数名.setOnClickListener(this)でエラーが発生する件
クラス全体に掛かるインターフェースを用いる必要がある
classの行を `class MainActivity : AppCompatActivity(), View.OnClickListener {` に書き換える

# onClickメソッドをoverrideしようとしたときにエラーが発生する件
onCreateメソッド内で他の関数を上書しようとしていたことが原因
overrideするときはonCreate関数外で行う用にしよう！