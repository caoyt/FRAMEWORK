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
	
	//���ñ�����ɫ
	//config.uiColor = '#0085CA';
	
	//config.language:'zh-cn'; //��������
	
	//ȥ���༭���·���p body
	config.removePlugins = 'elementspath';
	
	//���������
	config.extraPlugins = 'font';
	
	//������������
	config.font_names = '����;����_GB2312;������;����;����;��Բ;΢���ź�;Arial;';
	
	
	//���
	//config.width = 650px;
	
	//�߶�
	//config.height=300;
	
	//�������Ƿ���Ա�����
	config.toolbarCanCollapse = true;
	
	//��������λ��
	config.toolbarLocation = 'top';//bottom

	//������Ĭ���Ƿ�չ��
	config.toolbarStartupExpanded = true;

	//ȡ�� ����ק�Ըı�ߴ硱����
	config.resize_enabled = false;
	
	
	//�ı��С�����߶�
	//config.resize_maxHeight = 3000;
	
	//�ı��С����󌒶�
	//config.resize_maxWidth = 3000;
	
	//�ı��С����С�߶�
	//config.resize_minHeight = 250;
	
	//�ı��С����С����
	//config.resize_minWidth = 750;
	
	
	
	// ���ύ�����д˱༭���ı�ʱ���Ƿ��Զ�����Ԫ�؃ȵ�����
	//config.autoUpdateElement = true;
	
	// ������ʹ�þ���Ŀ¼������ĿĿ¼��Ϊ�ձ�ʾ���Ŀ¼
	//config.baseHref = '';
	
	//�س��������ı��  p  ��ѡCKEDITOR.ENTER_BR��CKEDITOR.ENTER_DIV
	config.enterMode = CKEDITOR.ENTER_P;
	
	//���û�����TAB����ʱ��Ĭ�Ͽո�������
	config.tabSpaces = 4;
	
	
	
	//ɾ�����ͼƬ��ʱ��Ԥ���е����ֵķ���
	config.image_previewText=' ';
	
	//ͼƬ�ϴ���URL
	config.filebrowserImageUploadUrl='/admin.action';
	
	// ����"ͼ��"ѡ�����ʾͼƬ    
	/*����������
	out.println("<script type=\"text/javascript\">");      
	out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + "/eHomePlus/img/uploadImg" + fileName + "','')");      
	out.println("</script>");  
	*/

	
	
};
