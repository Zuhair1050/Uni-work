package ClientAndServer;

/**
* ClientAndServer/RegOfficeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RegOffice.idl
* Thursday, 13 April 2017 13:17:23 o'clock BST
*/

public final class RegOfficeHolder implements org.omg.CORBA.portable.Streamable
{
  public ClientAndServer.RegOffice value = null;

  public RegOfficeHolder ()
  {
  }

  public RegOfficeHolder (ClientAndServer.RegOffice initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ClientAndServer.RegOfficeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ClientAndServer.RegOfficeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ClientAndServer.RegOfficeHelper.type ();
  }

}