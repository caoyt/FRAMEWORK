/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'about' }
	];
	
	

	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	//config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	//config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	//config.removeDialogTabs = 'image:advanced;link:advanced';
	
	//设置背景颜色
	//config.uiColor = '#0085CA';
	
	//config.language:'zh-cn'; //界面语言
	
	//去掉编辑器下方的p body
	config.removePlugins = 'elementspath';
	
	//添加字体插件
	config.extraPlugins = 'font';
	
	//设置字体内容
	config.font_names = '宋体;楷体_GB2312;新宋体;黑体;隶书;幼圆;微软雅黑;Arial;';
	
	
	//宽度
	//config.width = 650px;
	
	//高度
	//config.height=300;
	
	//工具栏是否可以被收缩
	config.toolbarCanCollapse = true;
	
	//工具栏的位置
	config.toolbarLocation = 'top';//bottom

	//工具栏默认是否展开
	config.toolbarStartupExpanded = true;

	//取消 “拖拽以改变尺寸”功能
	config.resize_enabled = false;
	
	
	//改变大小的最大高度
	//config.resize_maxHeight = 3000;
	
	//改变大小的最大寬度
	//config.resize_maxWidth = 3000;
	
	//改变大小的最小高度
	//config.resize_minHeight = 250;
	
	//改变大小的最小寬度
	//config.resize_minWidth = 750;
	
	
	
	// 当提交包含有此编辑器的表单时，是否自动更新元素內的资料
	//config.autoUpdateElement = true;
	
	// 设置是使用绝对目录还是项目目录，为空表示相对目录
	//config.baseHref = '';
	
	//回车键产生的标号  p  可选CKEDITOR.ENTER_BR或CKEDITOR.ENTER_DIV
	config.enterMode = CKEDITOR.ENTER_P;
	
	//当用户键入TAB键的时候默认空格数几个
	config.tabSpaces = 4;
	
	
	
	//删除添加图片的时候预览中的文字的方法
	config.image_previewText=' ';
	
	//图片上传的URL
	config.filebrowserImageUploadUrl='/admin.action';
	
	// 返回"图像"选项卡并显示图片    
	/*服务器代码
	out.println("<script type=\"text/javascript\">");      
	out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + "/eHomePlus/img/uploadImg" + fileName + "','')");      
	out.println("</script>");  
	*/

	
	
};
