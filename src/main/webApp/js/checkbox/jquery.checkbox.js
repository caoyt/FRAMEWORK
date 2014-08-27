
/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-07-30
 */
(function(jQuery){
	/**
	 * 全选/反选 
	 * @return 全选内容的ID 
	 */
	$.fn.checkBoxAll = function (){
		//获取name=checkbox的值,如果函数传递了参数就根据参数获取对象,如果没有传递参数默认为checkbox
		var checkbox =  arguments[0] || "checkbox";
		var checkbox_arr_obj = $("input[name='"+checkbox+"']");
		
		//返回的结果数组
		var result_arr = [];
		
		if($(this).attr("checked")){
			checkbox_arr_obj.attr("checked",true);
			//遍历对象数组,获取其value值
			$(checkbox_arr_obj).each(function(index, value){
				result_arr.push($(this).val());
			});;
		}else{
			checkbox_arr_obj.attr("checked",false);
			result_arr = [];
		}
		//为实例对象添加属性,目的是为了配合checkBox函数的使用
		$.fn.checkboxArr = result_arr;
		return result_arr;
	};
	
	/**
	 * 复选框单选
	 * @result 选中的checkbox的value值数组
	 */
	$.fn.checkBox = function (){
		//获取全选操作后保存的ID数组
		var checkbox_arr = $(this).checkboxArr || [];
		
		//根据ID获取全选按钮的checkbox对象,默认为checkboxAll
		var checkboxAll =  arguments[0] || "checkboxAll";
		
		//获取当前单击的checkbox的value
		var val = $(this).val();
		
		if($(this).attr("checked")){
			
			//假如返回数组
			checkbox_arr.push($(this).val());
			
			//根据当前单击checkbox的name属性的值获取和当前单击的checkbox相同name值的对象
			var check_name = $(this).attr("name");
			
			var len = $("input[name='"+check_name+"']").length;
			
			//如果所有的checkbox都选中了，那么全选按钮选中
			if(checkbox_arr.length == len){
				$("#"+checkboxAll).attr("checked",true);
			}
			
			
			
		}else{
			//从返回数组中删除当前单击的元素的value的值
			$.each(checkbox_arr,function(index,value){
				if(value == val){
					checkbox_arr.splice(index,1);
				}
			});
			
			//如果所有checkbox都已取消了选中,那么全选按钮也取消选中
			if(checkbox_arr.length == 0){
				$("#"+checkboxAll).attr("checked",false);
			}
			
			$(this).checkboxArr = checkbox_arr;
		}
		
		$.fn.checkboxArr = checkbox_arr;
		
		return checkbox_arr;
		
	};
})(jQuery);



