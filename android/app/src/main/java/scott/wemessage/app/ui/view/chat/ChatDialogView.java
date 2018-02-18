package scott.wemessage.app.ui.view.chat;

import com.stfalcon.chatkit.commons.models.IDialog;
import com.stfalcon.chatkit.commons.models.IMessage;

import java.util.ArrayList;
import java.util.List;

import scott.wemessage.app.models.chats.Chat;
import scott.wemessage.app.models.chats.GroupChat;
import scott.wemessage.app.models.chats.PeerChat;
import scott.wemessage.app.models.users.Handle;
import scott.wemessage.app.ui.view.messages.MessageView;
import scott.wemessage.app.ui.view.messages.UserView;
import scott.wemessage.app.utils.IOUtils;
import scott.wemessage.app.weMessage;

public class ChatDialogView implements IDialog {

    private Chat chat;
    private List<UserView> users = new ArrayList<>();
    private MessageView lastMessage;
    private String dialogPhoto;
    private String dialogName;
    private int unreadMessages;

    public ChatDialogView(Chat chat){
        this.chat = chat;
        this.lastMessage = new MessageView(weMessage.get().getMessageDatabase().getLastMessageFromChat(chat));
        this.dialogPhoto = IOUtils.getChatIconUri(chat, IOUtils.IconSize.NORMAL);

        try {
            this.unreadMessages = booleanToInteger(weMessage.get().getMessageDatabase().getChatByIdentifier(getId()).hasUnreadMessages());
        }catch (Exception ex){
            this.unreadMessages = 0;
        }

        if (chat.getChatType() == Chat.ChatType.PEER){
            users.add(new UserView(((PeerChat) chat).getHandle()));
        }else {
            GroupChat groupChat = (GroupChat) chat;

            for (Handle h : groupChat.getParticipants()){
                users.add(new UserView(h));
            }
        }

        if (chat.getChatType() == Chat.ChatType.PEER){
            this.dialogName = users.get(0).getName();
        } else {
            GroupChat groupChat = (GroupChat) chat;
            this.dialogName = groupChat.getUIDisplayName(false);
        }
    }

    @Override
    public String getId() {
        return chat.getIdentifier();
    }

    @Override
    public String getDialogPhoto() {
        return dialogPhoto;
    }

    @Override
    public String getDialogName() {
        return dialogName;
    }

    @Override
    public List<? extends UserView> getUsers() {
        return users;
    }

    @Override
    public MessageView getLastMessage() {
        return lastMessage;
    }

    @Override
    public void setLastMessage(IMessage message) {
        this.lastMessage = (MessageView) message;
    }

    @Override
    public int getUnreadCount() {
        return unreadMessages;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ChatDialogView && ((ChatDialogView) obj).getId().equals(getId());
    }

    private int booleanToInteger(boolean bool){
        if (bool) return 1;
        else return 0;
    }
}