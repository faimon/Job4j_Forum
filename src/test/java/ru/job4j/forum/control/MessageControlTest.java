package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Application;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.MessageService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class MessageControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;


    @Test
    @WithMockUser
    void getMessages() throws Exception {
        this.mockMvc.perform(get("/message")
                .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("messages"));
    }

    @Test
    @WithMockUser
    void saveMessage() throws Exception {
        this.mockMvc.perform(post("/message")
                .param("postId", "1")
                .flashAttr("message", new Message("some text", "Ivan")))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/message?id=1"));
        ArgumentCaptor<Message> messageCaptor = ArgumentCaptor.forClass(Message.class);
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);

        verify(messageService).addMessage(messageCaptor.capture(), integerCaptor.capture());

        assertThat(messageCaptor.getValue().getText(), is("some text"));
        assertThat(messageCaptor.getValue().getUsername(), is("Ivan"));
        assertThat(integerCaptor.getValue(), is(1));
    }
}