function submitForm() {
    let resultCheck = true;
    let resultCheckPhone = checkPhone();
    if (!resultCheckPhone) { resultCheck = false; }
    let resultCheckEmail = checkEmail();
    if (!resultCheckEmail) { resultCheck = false; }
    let resultCheckCustomerCode = checkCustomerCode();
    if (!resultCheckCustomerCode) { resultCheck = false; }
    return resultCheck;
}

function checkCustomerCode() {
    var txt = $("#customerCode");
    var error = $("#customer_code_error");
    error.html("");
    txt.removeClass("is-valid").removeClass("is-invalid");
    var val = txt.val();
    var regex = /^(KH)[0-9]{5}$/i
    if (!regex.test(val)) {
        error.html("Code must be KHxxxxx (x is number)");
        txt.addClass("is-invalid");
        return false;
    } else {
        txt.addClass("is-valid");
    }
    return true;
}

/* Chỉ cho phép nhập số, 10 kí tự, đầu số phải là 090xxxxxxx, 091xxxxxxx, (84)+91xxxxxxx,(84)+90xxxxxxx */
function checkPhone() {
    var txt = $("#phone");
    var error = $("#phone_error");
    error.html("");
    txt.removeClass("is-valid").removeClass("is-invalid");
    var val = txt.val();
    var regex = /^(090|091|[(]{1,1}84[)]{1,1}[+]{1,1}90|[(]{1,1}84[)]{1,1}[+]{1,1}91)[0-9]{7}$/i
    if (!regex.test(val)) {
        error.html("Phone number must be one of these type 090xxxxxxx, 091xxxxxxx, (84)+91xxxxxxx,(84)+90xxxxxxx");
        txt.addClass("is-invalid");
        return false;
    } else {
        txt.addClass("is-valid");
    }
    return true;
}

function checkEmail() {
    var txt = $("#email");
    var error = $("#email_error");
    error.html("");
    txt.removeClass("is-valid").removeClass("is-invalid");
    var val = txt.val();
    // abcd123@abcd.zyz
    var regex = /^[a-z]+[0-9]*@([a-z0-9]+[.])+([a-z]{2,})$/i;
    // var regex = /^[a-z]+[0-9]*@fsoft.com.vn$/i;
    if (!regex.test(val)) {
        error.html("Email you enter must have @ ");
        txt.addClass("is-invalid");
        return false;
    } else {
        txt.addClass("is-valid");
    }
    return true;
}