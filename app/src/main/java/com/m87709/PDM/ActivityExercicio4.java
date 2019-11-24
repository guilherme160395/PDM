package com.m87709.PDM;

import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityExercicio4 extends AppCompatActivity {

    public final int SELECIONAR_CONTATO = 0;
    public final int SELECIONAR_CONTATO2 = 1;
    TextView tvNome, tvPhone;
    ImageView ivImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio4);

        tvNome = (TextView) findViewById(R.id.txtNome);
        tvPhone = (TextView) findViewById(R.id.txtTelefone);
        ivImagem = (ImageView) findViewById(R.id.foto);
    }

    public void selecionarContato(View view) {
        //verificar permissao de leitura de contatos em Configuraçoes do Dispositivo
        Uri uri = Uri.parse("content://com.android.contacts/contacts");
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(intent, SELECIONAR_CONTATO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECIONAR_CONTATO2 && resultCode == RESULT_OK) {
            Uri contactData = data.getData();

            Cursor phones = getContentResolver()
                    .query(contactData,
                            null,
                            null,
                            null,
                            null);

            String name = "", phoneNumber = "";

            while (phones.moveToNext()) {
                name = phones.getString(phones.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                phoneNumber = phones.getString(phones.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.NUMBER));

            }
            phones.close();
            tvNome.setText(name);
            tvPhone.setText(phoneNumber);
        } else {

            if (requestCode == SELECIONAR_CONTATO && resultCode == RESULT_OK) {
                Uri uri = data.getData();
                //Cursor c = managedQuery(uri,null,null,null,null);
                Cursor c = getContentResolver().query(uri, null, null, null, null);
                c.moveToNext();
                int nameCol = c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME);
                int idCol = c.getColumnIndexOrThrow(ContactsContract.Contacts._ID);
                String nome = c.getString(nameCol);
                String id = c.getString(idCol);
                //Toast.makeText(this, "Contato: " + nome, Toast.LENGTH_SHORT).show();
                c.close();

                Cursor phones = getContentResolver().query
                        (ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID +
                                        " = " + id, null, null);
                phones.moveToNext();
                String phoneNumber = phones.getString
                        (phones.getColumnIndexOrThrow
                                (ContactsContract.CommonDataKinds.Phone.NUMBER));
                //Toast.makeText(this, "Numero: " + phoneNumber, Toast.LENGTH_SHORT).show();
                phones.close();
                TextView tvNome = (TextView) findViewById(R.id.txtNome);
                tvNome.setText(nome);
                TextView tvPhone = (TextView) findViewById(R.id.txtTelefone);
                tvPhone.setText(phoneNumber);
            } else if (requestCode == 123 && resultCode == RESULT_OK) {

                //retorno da camera
                super.onActivityResult(requestCode, resultCode, data);
                Bitmap bm;
                ImageView iv = (ImageView) findViewById(R.id.foto);
                if(requestCode == 123 & resultCode == RESULT_OK){
                    bm = (Bitmap) data.getExtras().get("data");
                    iv.setImageBitmap(bm);
                    iv.setScaleType(ImageView.ScaleType.FIT_XY);
                }
            }
        }

    }

    public void lerContatos2Click(View view) {
        //verificar permissao de leitura de contatos em Configuraçoes do Dispositivo
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(intent, SELECIONAR_CONTATO2);
    }

    public void acessarSite(View view) {
        Uri uri = Uri.parse("https://www.unisc.br");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void efetuarChamadaTelefonica(View view) {
        Uri uri = Uri.parse("tel: 998877665");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    public void maps1(View view) {
    }

    public void maps2(View view) {
    }

    public void maps3(View view) {
    }

    public void tirarFoto(View view) {
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(it,123);
    }

}