#!/usr/bin/env bash

# 弃用该方法 原因嘛……  慢。并且没必要一直更软件
#git clone https://github.com/aimobier/OddityUI --branch develop-asdk --single-branch $1
# cd $1
# pod update


# $1 为 IOS 项目目录
# $2 为 IOS 项目将要复制到的目录
# $3 为 info.plist 文件的 路径

# $4 为 ICON 文件路径
# $5 为 Launch 文件路径
# $6 为 LaunchStoryBoard 文件路径

# $7 为 fastlane 配置文件路径

## 复制IOS 项目到目录下
cp -rf $1 $2

iosPath=$2"/"$(basename $1)
iosRootPath=$iosPath"/Example/"
iosFastlanePath=$iosPath"/fastlane/"
iosSourcesPath=$iosPath"/Assets.xcassets/"

## 进入IOS的项目下
cd $iosPath

## 复制 Info.plist
cp -rf $3 $iosRootPath

## 复制 Icon
cp -rf $4 $iosSourcesPath
## 复制 Launch
cp -rf $5 $iosSourcesPath
## 复制 LaunchStorBoard
cp -rf $6 $iosSourcesPath

#fastlane init

#mkdir fastlane
#
#cp -rf $7 $iosFastlanePath
#cp -rf $8 $iosFastlanePath
#fastlane release
