/**
 * Created by aleksandar on 22.6.16..
 */
function issueInvoice(formName) {

    $("#"+formName).ajaxSubmit(
        {
            url: 'api/issueinvoice/getinvoices',
            type: 'post'
        }
    );
}