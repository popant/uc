<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="metronicHeader.jsp" />
<title>Insert title here</title>
</head>
<body>
	<form role="form" class="form-horizontal">
		<div class="form-body">
			<div class="form-group form-md-line-input">
				<label class="col-md-2 control-label " for="form_control_1">正常</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="form_control_1"
						placeholder="提示">
					<div class="form-control-focus"></div>
				</div>
			</div>
			<div class="form-group form-md-line-input has-success">
				<label class="col-md-2 control-label" for="form_control_1">绿色</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="form_control_1"
						placeholder="提示">
					<div class="form-control-focus"></div>
				</div>
			</div>
			<div class="form-group form-md-line-input has-error">
				<label class="col-md-2 control-label" for="form_control_1">错误</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="form_control_1"
						placeholder="提示">
					<div class="form-control-focus"></div>
				</div>
			</div>
			<div class="form-group form-md-line-input">
				<label class="col-md-2 control-label" for="form_control_1">下拉框</label>
				<div class="col-md-10">
					<select class="form-control" id="form_control_1">
						<option value=""></option>
						<option value="">Option 1</option>
						<option value="">Option 2</option>
						<option value="">Option 3</option>
						<option value="">Option 4</option>
					</select>
					<div class="form-control-focus"></div>
				</div>
			</div>
			<div class="form-group form-md-line-input has-success">
				<label class="col-md-2 control-label" for="form_control_1">文本域</label>
				<div class="col-md-10">
					<textarea class="form-control" rows="3"
						placeholder="提示"></textarea>
					<div class="form-control-focus"></div>
				</div>
			</div>
			<div class="form-group form-md-line-input">
				<label class="col-md-2 control-label" for="form_control_1">Disabled</label>
				<div class="col-md-10">
					<input type="text" class="form-control" disabled
						id="form_control_1" placeholder="Placeholder...">
					<div class="form-control-focus"></div>
				</div>
			</div>
			<div class="form-group form-md-line-input">
				<label class="col-md-2 control-label" for="form_control_1">Readonly</label>
				<div class="col-md-10">
					<input type="text" class="form-control" readonly value="Some value"
						id="form_control_1" placeholder="Placeholder...">
					<div class="form-control-focus"></div>
				</div>
			</div>
			<div class="form-group form-md-radios">
				<label class="col-md-2 control-label">单选框</label>
				<div class="col-md-10 md-radio-list">
					<div class="md-radio">
						<input type="radio" id="radio1" name="radio1" class="md-radiobtn">
						<label for="radio1"> <span></span> <span class="check"></span>
							<span class="box"></span> Option 1
						</label>
					</div>
					<div class="md-radio">
						<input type="radio" id="radio2" name="radio1" class="md-radiobtn"
							checked> <label for="radio2"> <span></span> <span
							class="check"></span> <span class="box"></span> Option 2
						</label>
					</div>
					<div class="md-radio">
						<input type="radio" id="radio3" name="radio1" class="md-radiobtn">
						<label for="radio3"> <span></span> <span class="check"></span>
							<span class="box"></span> Option 3
						</label>
					</div>
					<div class="md-radio">
						<input type="radio" id="radio5" name="radio1" disabled
							class="md-radiobtn"> <label for="radio5"> <span></span>
							<span class="check"></span> <span class="box"></span> Disabled
						</label>
					</div>
				</div>
			</div>
			<div class="form-group form-md-checkboxes">
				<label class="col-md-2 control-label" >复选框</label>
				<div class="col-md-10 md-checkbox-inline">
					<div class="md-checkbox">
						<input type="checkbox" id="checkbox6" class="md-check"> <label
							for="checkbox6"> <span></span> <span class="check"></span>
							<span class="box"></span> Option 1
						</label>
					</div>
					<div class="md-checkbox">
						<input type="checkbox" id="checkbox7" class="md-check" checked>
						<label for="checkbox7"> <span></span> <span class="check"></span>
							<span class="box"></span> Option 2
						</label>
					</div>
					<div class="md-checkbox">
						<input type="checkbox" id="checkbox8" class="md-check"> <label
							for="checkbox8"> <span></span> <span class="check"></span>
							<span class="box"></span> Option 3
						</label>
					</div>
				</div>
			</div>
		</div>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-offset-2 col-md-10">
					<button type="button" class="btn default">取消</button>
					<button type="button" class="btn blue">提交</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>