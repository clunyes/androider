# Android实用命令
dumpsys meminfo

top

dumpsys activity activities | grep ecarx.settings

adb shell dumpsys gfxinfo

pm clear com.ecarx.xcmascot

am start -n com.ecarx.accountcenter.sample/com.ecarx.accountcenter.provision.view.ProvisionLoginActivity

am broadcast -a ecarx.intent.action.SCENE_MOCK_EVENT_REVEIVER -p com.ecarx.smartscene --es key "mock_commuteOn" --es data "default_navi_app:1/

cat main_log_12__2021_0426_154515 | grep "04-26 15:4[1-4]" > 44.txt

dumpsys window | grep mCurrentFocus