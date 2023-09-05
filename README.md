# halo-plugin-ads

Halo 2.x 谷歌广告ads文件支持插件

## 功能简介

该插件用于支持Google Adsense的ads.txt文件在根目录访问

## 参与开发

插件开发的详细文档请查阅：https://docs.halo.run/developer-guide/plugin/hello-world

```shell
git clone https://github.com/git-kings/halo-plugin-ads.git

# 或者当你 fork 之后

git clone https://github.com/{your_github_id}/halo-plugin-ads.git
```

```shell
cd path/to/halo-plugin-ads
```

```shell
# macOS / Linux
./gradlew build

# Windows
./gradlew.bat build
```

修改 Halo 配置文件：

```yaml
halo:
  plugin:
    runtime-mode: development
    fixedPluginPath:
      - "/path/to/halo-plugin-ads"
```

