from django import forms

class HomeForm(forms.Form):

    Blood_Group_Required = forms.CharField()
    Quantity = forms.IntegerField()
    Delivery_to_Blood_Bank_number = forms.CharField()



# <label for="bloodgroup1">Blood Group: </label>
#     <input id="bloodgroup" type="text" name="bloodgroup" >
#     <br>
#     <br>
#     <label for="quantity1">Quantity: </label>
#     <input id="quantity" type="text" name="quantity" >
#     <br>
#     <br>